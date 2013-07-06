package mu.validation.run;

import static mu.validation.utils.DateUtils.midnight;
import static org.mockito.Mockito.mock;

import mu.validation.domain.Contract;
import mu.validation.domain.ContractBuilder;
import mu.validation.domain.utils.Person;
import mu.validation.service.MoveContractService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "commonRun-context.xml")
public class R05_RunOrtogonalValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private MoveContractService moveContractService;


	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldValidateWithEverythingSet() {

		final Contract contract = ContractBuilder.builderWithStartDate().withZenonPerson().build();
		moveContractService.moveContract(contract, mock(Person.class));

	}

	@Test
	public void shouldNotValidateWithEndDateSet() {

		final Contract contract = ContractBuilder.builderWithStartDate().withZenonPerson().build();
		contract.setEndDate(midnight(2013,07,13));
		moveContractService.moveContract(contract, mock(Person.class));

	}



}
