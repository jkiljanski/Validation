package mu.validation.validators;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mu.validation.annotations.AdditionalContractValidation;
import mu.validation.domain.Contract;
import mu.validation.validators.additional.AdditionalContractValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionalContractValidationFacadeValidator implements ConstraintValidator<AdditionalContractValidation, Contract> {

	@Autowired
	private List<AdditionalContractValidator> additionalValidators;

	@Override
	public void initialize(final AdditionalContractValidation constraintAnnotation) {
	}

	@Override
	public boolean isValid(final Contract value, final ConstraintValidatorContext context) {
		//context.disableDefaultConstraintViolation();
		for (AdditionalContractValidator additionalValidator : additionalValidators) {
			additionalValidator.validate(value, context);
		}
		return true;
	}
}
