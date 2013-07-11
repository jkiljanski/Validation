package mu.validation.validators.additional;

import javax.validation.ConstraintValidatorContext;
import mu.validation.domain.Contract;

public interface AdditionalContractValidator {

	//even better, you should use wrapped ConstraintValidatorContext, to determine, if any constrains were added and not to use boolean return (it's evil!!!)
	boolean IS_VALID = true;
	boolean IS_INVALID = false;

	boolean validateAndReturnIsValid(Contract contract, ConstraintValidatorContext constraintValidatorContext);

}
