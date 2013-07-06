package mu.validation.domain.utils;

public class Age {

	private final int age;

	private int MATURE_AGE = 18;

	public Age(final int age) {
		this.age = age;
	}
	
	public boolean isMature(){
		return !isYoungerThan(MATURE_AGE);
	}

	public boolean isYoungerThan(int years) {
		return age < years;
	}

}
