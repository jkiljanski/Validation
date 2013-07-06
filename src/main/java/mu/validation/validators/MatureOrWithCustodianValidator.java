package mu.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mu.validation.annotations.MatureOrWithCustodian;
import mu.validation.domain.utils.Person;

public class MatureOrWithCustodianValidator implements ConstraintValidator<MatureOrWithCustodian, Person> {

	@Override
	public void initialize(final MatureOrWithCustodian constraintAnnotation) {
	}

	@Override
	public boolean isValid(final Person value, final ConstraintValidatorContext context) {
		if(value.getAge().isMature()){
			return true;
		}
		return value.getCustodian() != null;
	}
}
