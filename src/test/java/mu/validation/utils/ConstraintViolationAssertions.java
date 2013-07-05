package mu.validation.utils;

import static mu.validation.utils.StringUtils.interpolate;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import org.fest.assertions.GenericAssert;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 05/06/2012
 */
public class ConstraintViolationAssertions extends GenericAssert<ConstraintViolationAssertions, ConstraintViolation<?>> {

	protected ConstraintViolationAssertions(ConstraintViolation<?> actual) {
		super(ConstraintViolationAssertions.class, actual);
	}

	public static ConstraintViolationAssertions assertThat(ConstraintViolation<?> constraintViolation) {
		return new ConstraintViolationAssertions(constraintViolation);
	}

	public ConstraintViolationAssertions hasMessage(String expectedMessage) {
		String message = actual.getMessage();
		if (message == null) {
			fail("Message for constraint violation is null");
		}
		if (!message.equals(expectedMessage)) {
			fail(interpolate("Constraint Violation message [{}] is not equal to expected message [{}]", message, expectedMessage));
		}
		return this;
	}

	public ConstraintViolationAssertions isSetOnField(String expectedFieldName) {
		final Path propertyPath = actual.getPropertyPath();
		if (propertyPath == null) {
			fail("Property path for field is not set");
		}
		final String fieldName = propertyPath.toString();
		if (!fieldName.equals(expectedFieldName)) {
			fail(interpolate("Field name [{}] is not equal to expected field name [{}]", fieldName, expectedFieldName));
		}
		return this;
	}

	public ConstraintViolationAssertions isEqualToDescription(ConstraintViolationDescription description) {
		hasMessage(description.message);
		isSetOnField(description.fieldName);
		return this;
	}

}
