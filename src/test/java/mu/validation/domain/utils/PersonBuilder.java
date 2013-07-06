package mu.validation.domain.utils;

public class PersonBuilder {

	private Person person;

	private PersonBuilder() {
		person = new Person();
	}

	public static PersonBuilder defaultPerson() {
		return new PersonBuilder().withFirstName("Zenon").withSecondName("Motyka").withAge(new Age(20));
	}

	public PersonBuilder withFirstName(final String firstName) {
		person.setFirstName(firstName);
		return this;
	}

	public PersonBuilder withSecondName(final String secondName) {
		person.setSecondName(secondName);
		return this;

	}

	public PersonBuilder withAge(final Age age) {
		person.setAge(age);
		return this;
	}

	public Person build() {
		return person;
	}
}
