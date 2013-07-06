package mu.validation.domain;

import static mu.validation.utils.DateUtils.midnight;

import java.util.Date;
import mu.validation.domain.utils.Person;
import mu.validation.domain.utils.PersonBuilder;

public class ContractBuilder {

	private final Contract contract;

	private ContractBuilder() {
		contract = new Contract();
	}

	public static ContractBuilder builderWithStartDate(){
		return new ContractBuilder().withStartDate(midnight(2013,6,6));
	}

	public ContractBuilder withStartDate(Date date) {
		contract.setStartDate(date);
		return this;
	}

	public ContractBuilder withEndDate(Date date) {
		contract.setStartDate(date);
		return this;
	}

	public ContractBuilder withApproveDate(Date date) {
		contract.setApproveDate(date);
		return this;
	}


	public ContractBuilder withFieldToBeCustomValidated(String string){
		contract.setFieldToBeCustomValidated(string);
		return this;
	}

	public Contract build() {
		return contract;
	}

	public ContractBuilder withZenonPerson() {
		contract.setPerson(PersonBuilder.defaultPerson().build());
		return this;
	}

	public ContractBuilder withMieciuPerson() {
		final Person person = PersonBuilder.defaultPerson().build();
		person.setFirstName("Mieciu");
		contract.setPerson(person);
		return this;
	}
}
