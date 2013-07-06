package mu.validation.service;

import mu.validation.domain.Contract;
import mu.validation.domain.groups.OtherGroups;
import mu.validation.domain.utils.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveContractService {

	@Autowired
	private ValidationService validationService;

	public void moveContract(Contract contract, Person newPerson) {
		validateContractCanBeMoved(contract);
		contract.setFarmer(newPerson);
	}

	private void validateContractCanBeMoved(final Contract contract) {
		validationService.validateWithCustomGroup(contract, OtherGroups.BeforeMovingGroup.class);
	}

}
