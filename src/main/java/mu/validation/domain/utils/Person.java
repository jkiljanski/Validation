package mu.validation.domain.utils;

import javax.validation.constraints.NotNull;
import mu.validation.annotations.MatureOrWithCustodian;
import mu.validation.annotations.MinAge;

@MatureOrWithCustodian
public class Person {

	@NotNull
	private String firstName;

	@NotNull
	private String secondName;

	@NotNull
	@MinAge(value=5)
	private Age age;

	private Person custodian;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(final String secondName) {
		this.secondName = secondName;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(final Age age) {
		this.age = age;
	}

	public Person getCustodian() {
		return custodian;
	}

	public void setCustodian(final Person custodian) {
		this.custodian = custodian;
	}
}