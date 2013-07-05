package mu.validation.service.exception;

import java.util.Set;
import javax.validation.ConstraintViolation;
import mu.validation.domain.Contract;

public class ConstraintViolationException extends RuntimeException {

	private Set<ConstraintViolation<Contract>> constraints;

	public ConstraintViolationException(final Set<ConstraintViolation<Contract>> constraints) {
		this.constraints = constraints;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ConstraintViolationException with violations: [");
		for (ConstraintViolation<Contract> constraint : constraints) {
			sb.append(constraint.getMessage());
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(']');
		return sb.toString();
	}
}
