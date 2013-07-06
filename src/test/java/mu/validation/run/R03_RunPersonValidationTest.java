package mu.validation.run;

import mu.validation.domain.Contract;
import mu.validation.domain.ContractBuilder;
import mu.validation.domain.utils.Age;
import mu.validation.domain.utils.PersonBuilder;
import mu.validation.service.ValidationService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "commonRun-context.xml")
public class R03_RunPersonValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ValidationService validationService;

	private Contract contract;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		contract = ContractBuilder.builderWithStartDate().withZenonPerson().build();
	}

	@Test
	public void shouldValidatePerson() {

		validationService.validateContract(contract);

	}

	@Test
	public void shouldNotValidatePersonBecauseOfNoFirstName() {

		contract.getPerson().setFirstName(null);

		validationService.validateContract(contract);

	}

	@Test
	public void shouldNotValidatePersonBecauseOfTooYoungAge() {

		contract.getPerson().setAge(new Age(4));
		contract.getPerson().setCustodian(PersonBuilder.defaultPerson().build());

		validationService.validateContract(contract);

	}

	@Test
	public void shouldNotValidatePersonBecauseNotMatureYetAndNoCustodian() {

		contract.getPerson().setAge(new Age(17));

		validationService.validateContract(contract);

	}





}
