package mu.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import mu.validation.validators.MinAgeValidator;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {MinAgeValidator.class})
public @interface MinAge {

	String message() default "{validation.constraints.MinAge.message}";

	Class<?>[] groups() default {};

	int value() default 0;

	Class<? extends Payload>[] payload() default {};
}
