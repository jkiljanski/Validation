package mu.validation.run;

import mu.validation.domain.Contract;
import mu.validation.domain.ContractBuilder;
import mu.validation.service.ValidationService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "commonRun-context.xml")
public class R02_RunStatusValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ValidationService validationService;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldValidateDraft() {

		final Contract contract = ContractBuilder.builderWithStartDate().withDefaultPerson().build();
		validationService.validateContract(contract);

	}



}
