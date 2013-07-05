package mu.validation.domain;

import static org.mockito.Mockito.mock;

import java.util.Date;
import mu.validation.domain.utils.Person;

public class ContractBuilder {

	private Contract contract = new Contract();

	private ContractBuilder() {
	}

	public static ContractBuilder builder(){
		return new ContractBuilder();
	}

	public ContractBuilder withStartDate(Date date) {
		contract.setStartDate(date);
		return this;
	}

	public ContractBuilder withEndDate(Date date) {
		contract.setStartDate(date);
		return this;
	}

	public ContractBuilder withMockedFarmer(){
		contract.setFarmer(mock(Person.class));

		return this;
	}

	public ContractBuilder withFieldToBeCustomValidated(String string){
		contract.setFieldToBeCustomValidated(string);
		return this;
	}

	public Contract build() {
		return contract;
	}

}
