package mu.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import mu.validation.validators.AdditionalContractValidationValidator;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {AdditionalContractValidationValidator.class})
public @interface AdditionalContractValidation {

	String message() default "{no-message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
