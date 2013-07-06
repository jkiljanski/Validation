package mu.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import mu.validation.validators.MatureOrWithCustodianValidator;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {MatureOrWithCustodianValidator.class})
public @interface MatureOrWithCustodian {

	String message() default "{validation.constraints.MatureOrWithCustodian.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
