package mu.validation.annotations.other;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Min(value = 0, message = "validation.constraints.percent.message")
//to override default Min i Max values
@Max(value = 1, message = "validation.constraints.percent.message")
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface Percent {

	String message() default "validation.constraints.percent.message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
