package mu.validation.run;

import javax.validation.groups.Default;
import mu.validation.domain.Contract;
import mu.validation.domain.ContractBuilder;
import mu.validation.domain.groups.CustomValidationGroups;
import mu.validation.service.ValidationService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "commonRun-context.xml")
public class R01_RunCustomGroupValidationTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ValidationService validationService;

	private Contract contract;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		contract = ContractBuilder.builderWithStartDate().withZenonPerson().build();
	}

	@Test
	public void shouldNotValidateForA() {

		validationService.validateWithCustomGroup(contract, CustomValidationGroups.A.class);

	}

	@Test
	public void shouldNotValidateForB() {

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

	@Test
	public void shouldValidateForDefaultGroup() {

		validationService.validateWithCustomGroup(contract, Default.class);

	}

}
