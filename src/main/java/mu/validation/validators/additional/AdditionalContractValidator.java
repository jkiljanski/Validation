package mu.validation.validators.additional;

import javax.validation.ConstraintValidatorContext;
import mu.validation.domain.Contract;

public interface AdditionalContractValidator {

	void validate(Contract contract, ConstraintValidatorContext constraintValidatorContext);

}
