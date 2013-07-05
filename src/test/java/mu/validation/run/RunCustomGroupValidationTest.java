package mu.validation.run;

import mu.validation.domain.Contract;
import mu.validation.domain.utils.Person;
import mu.validation.domain.utils.status.ContractStatusContext;
import mu.validation.service.ValidationService;
import mu.validation.service.groups.CustomValidationGroups;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "commonRun-context.xml")
public class RunCustomGroupValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ValidationService validationService;

	@Mock
	private Person farmerMock;

	private Contract contract;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		contract = new Contract(farmerMock, new ContractStatusContext());
	}

	@Test
	public void shouldValidateForA() {

		validationService.validateWithCustomGroup(contract, CustomValidationGroups.A.class);

	}

	@Test
	public void shouldValidateForB() {

		validationService.validateWithCustomGroup(contract, CustomValidationGroups.B.class);

	}

	@Test
	public void shouldValidateForC() {

		validationService.validateWithCustomGroup(contract, CustomValidationGroups.C.class);

	}

	@Test
	public void shouldValidateForNoGroup() {

		validationService.validateWithCustomGroup(contract);

	}



}
