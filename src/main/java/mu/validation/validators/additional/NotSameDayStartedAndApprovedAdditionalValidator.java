package mu.validation.validators.additional;

import javax.validation.ConstraintValidatorContext;
import mu.validation.domain.Contract;
import mu.validation.utils.DateUtils;
import org.springframework.stereotype.Component;

@Component
public class NotSameDayStartedAndApprovedAdditionalValidator implements AdditionalContractValidator {

	public static final String MESSAGE_TEMPLATE = "{validation.constraints.NotSameDayStartedAndApprovedAdditionalValidator.message}";

	@Override
	public boolean validateAndReturnIsValid(final Contract contract, final ConstraintValidatorContext constraintValidatorContext) {
		if (!DateUtils.areDatesEqual(contract.getStartDate(), contract.getApproveDate())) {
			return IS_VALID;
		}

		constraintValidatorContext.buildConstraintViolationWithTemplate(MESSAGE_TEMPLATE).addNode("approveDate").addConstraintViolation();
		return IS_INVALID;
	}
}
