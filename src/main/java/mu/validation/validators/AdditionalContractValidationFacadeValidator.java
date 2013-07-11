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
		context.disableDefaultConstraintViolation();
		boolean isValid = true; // you can put OR // AND // XOR logic
		for (AdditionalContractValidator additionalValidator : additionalValidators) {
			isValid &= additionalValidator.validateAndReturnIsValid(value, context);
		}
		return isValid;
	}
}
