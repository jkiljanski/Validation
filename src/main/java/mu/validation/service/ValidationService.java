package mu.validation.service;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import mu.validation.domain.Contract;
import mu.validation.service.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {

	private final Validator validator;

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public ValidationService(final Validator validator) {
		this.validator = validator;


	}

	public void validateContract(Contract contract){
		final Class<?> validationGroup = contract.getValidationGroup();

		final Set<ConstraintViolation<Contract>> constraints = validator.validate(contract, validationGroup);

		if (constraints.isEmpty()){
			return;
		}

		throw new ConstraintViolationException(constraints);
	}


}
