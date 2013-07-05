package mu.validation.run;

import mu.validation.domain.Contract;
import mu.validation.domain.utils.Person;
import mu.validation.domain.utils.status.ContractStatusContext;
import mu.validation.service.ValidationService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration
public class RunStatusValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ValidationService validationService;

	@Mock
	private Person farmerMock;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldValidateDraft() {

		validationService.validateContract(new Contract(farmerMock, new ContractStatusContext()));

	}



}
