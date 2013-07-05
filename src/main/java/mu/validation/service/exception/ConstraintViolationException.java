package mu.validation.service.exception;

import java.util.Set;
import javax.validation.ConstraintViolation;
import mu.validation.domain.Contract;

public class ConstraintViolationException extends RuntimeException {

	public static final String LINE = "--------------------------------------------";

	private final Set<ConstraintViolation<Contract>> constraints;

	public ConstraintViolationException(final Set<ConstraintViolation<Contract>> constraints) {
		this.constraints = constraints;
	}

	public Set<ConstraintViolation<Contract>> getConstraints() {
		return constraints;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(LINE).append('\n');
		sb.append("ConstraintViolationException with violations:\n");
		for (ConstraintViolation<Contract> constraint : constraints) {
			sb.append(constraint.getPropertyPath()).append(':').append(constraint.getMessage());
			sb.append('\n');
		}
		sb.append(LINE);
		return sb.toString();
	}
}
