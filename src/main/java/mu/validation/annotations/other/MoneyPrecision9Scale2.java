package mu.validation.annotations.other;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@DecimalMin(value = "0", message = "validation.constraints.moneyPrecision9Scale2.range")
@DecimalMax(value = "9999999.99", message = "validation.constraints.moneyPrecision9Scale2.range")
@Digits(integer = 7, fraction = 2, message = MoneyPrecision9Scale2.DIGITS_MESSAGE)
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface MoneyPrecision9Scale2 {

	String DIGITS_MESSAGE = "validation.constraints.moneyPrecision9Scale2.digits";

	String message() default "validation.constraints.moneyPrecision9Scale2.range";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
