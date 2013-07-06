package mu.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mu.validation.annotations.MinAge;
import mu.validation.domain.utils.Age;

public class MinAgeValidator implements ConstraintValidator<MinAge, Age> {

	private int minAge;

	@Override
	public void initialize(final MinAge constraintAnnotation) {
		minAge = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(final Age value, final ConstraintValidatorContext context) {
		return !value.isYoungerThan(minAge);
	}
}
