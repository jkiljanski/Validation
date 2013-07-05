package mu.validation.utils;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 05/06/2012
 */
public class ConstraintViolationDescription {

	public String fieldName;

	public String message;

	public String customIdentifier;

	public ConstraintViolationDescription(final String fieldName) {
		this(fieldName, null, null);
	}

	public ConstraintViolationDescription(final String fieldName, final String message) {
		this(fieldName, message, null);
	}

	public ConstraintViolationDescription(final String fieldName, final String message, final String customIdentifier) {
		this.fieldName = fieldName;
		this.message = message;
		this.customIdentifier = customIdentifier;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ConstraintViolationDescription)) {
			return false;
		}

		final ConstraintViolationDescription that = (ConstraintViolationDescription) o;

		if (customIdentifier != null ? !customIdentifier.equals(that.customIdentifier) : that.customIdentifier != null) {
			return false;
		}
		if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) {
			return false;
		}
		if (message != null ? !message.equals(that.message) : that.message != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = fieldName != null ? fieldName.hashCode() : 0;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (customIdentifier != null ? customIdentifier.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ConstraintViolationDescription{" +
				"fieldName='" + fieldName + '\'' +
				", message='" + message + '\'' +
				", customIdentifier='" + customIdentifier + '\'' +
				'}';
	}
}
