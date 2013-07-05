package mu.validation.utils;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import org.fest.assertions.Assertions;
import org.fest.assertions.GroupAssert;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 05/06/2012
 */
public class ConstraintViolationCollectionAssertions
		extends GroupAssert<ConstraintViolationCollectionAssertions, Collection<? extends ConstraintViolation<?>>> {

	protected ConstraintViolationCollectionAssertions(Collection<? extends ConstraintViolation<?>> actual) {
		super(ConstraintViolationCollectionAssertions.class, actual);
	}

	public static ConstraintViolationCollectionAssertions assertThat(Collection<? extends ConstraintViolation<?>> actual) {
		return new ConstraintViolationCollectionAssertions(actual);
	}

	public ConstraintViolationCollectionAssertions containsOnlyConstraintDescribedBy(ConstraintViolationDescription... expectedDescriptions) {
		final Iterable<ConstraintViolationDescription> descriptions = Iterables.transform(actual, createTransformerToDescription());
		Assertions.assertThat(descriptions).containsOnly(expectedDescriptions);
		return this;
	}

	private Function<ConstraintViolation<?>, ConstraintViolationDescription> createTransformerToDescription() {
		return new Function<ConstraintViolation<?>, ConstraintViolationDescription>() {
			@Override
			public ConstraintViolationDescription apply(final ConstraintViolation<?> input) {
				if (input == null) {
					return null;
				}
				return new ConstraintViolationDescription(withdrawFieldName(input), input.getMessage());
			}
		};

	}

	private String withdrawFieldName(final ConstraintViolation<?> input) {
		final Path propertyPath = input.getPropertyPath();
		if (propertyPath == null) {
			return null;
		}
		return propertyPath.toString();
	}

	public void containPaths(String... paths) {
		Set<String> violatedPaths = getPaths();
		Assertions.assertThat(violatedPaths).contains((Object[]) paths);
	}

	public void containMessages(String... msgs) {
		Set<String> violatedMsgs = getMessages();
		Assertions.assertThat(violatedMsgs).contains((Object[]) msgs);
	}

	public void notContainPaths(String... paths) {
		Set<String> violatedPaths = getPaths();
		Assertions.assertThat(violatedPaths).excludes((Object[]) paths);
	}

	private Set<String> getPaths() {
		Set<String> violatedPaths = Sets.newHashSet();

		for (ConstraintViolation<?> violation : actual) {
			String pathString = violation.getPropertyPath().toString();
			violatedPaths.add(pathString);
		}
		return violatedPaths;
	}

	private Set<String> getMessages() {
		Set<String> violatedMsgs = Sets.newHashSet();

		for (ConstraintViolation<?> violation : actual) {
			String msgString = violation.getMessageTemplate();
			violatedMsgs.add(msgString);
		}
		return violatedMsgs;
	}

	@Override
	protected int actualGroupSize() {
		isNotNull();
		return actual.size();
	}
}
