package mu.validation.domain;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import mu.validation.annotations.AdditionalContractValidation;
import mu.validation.domain.groups.CustomValidationGroups;
import mu.validation.domain.groups.OtherGroups;
import mu.validation.domain.utils.Person;
import mu.validation.domain.utils.status.ContractStatus;
import mu.validation.domain.utils.status.ContractStatusContext;
import mu.validation.domain.utils.status.validation.StatusValidationGroups;

@AdditionalContractValidation(groups = StatusValidationGroups.ActiveGroup.class)
public class Contract {

	@NotNull
	@Valid
	private Person person;

	private ContractStatusContext statusContext;

	@NotNull(groups = StatusValidationGroups.DraftGroup.class)
	private Date startDate;

	@NotNull(groups = StatusValidationGroups.ActiveGroup.class)
	private Date approveDate;

	@Null(groups = OtherGroups.BeforeMovingGroup.class)
	private Date endDate;

	@NotNull(groups = CustomValidationGroups.A.class)
	private String fieldToBeCustomValidated;

	protected Contract() {
		statusContext = new ContractStatusContext();
	}

	public Contract(final Person person) {
		this.person = person;
		this.statusContext = new ContractStatusContext();
	}

	public void sign() {
		statusContext.sign();
	}

	public void approve(){
		statusContext.approve();
	}

	public void dishonor() {
		statusContext.dishonor();
	}

	public void cancel() {
		statusContext.cancel();
	}

	public void end() {
		statusContext.end();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(final Person person) {
		this.person = person;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(final Date approveDate) {
		this.approveDate = approveDate;
	}

	public ContractStatus getContractStatus() {
		return statusContext.getContractStatus();
	}

	public Class<?> getValidationGroup() {
		return getContractStatus().getValidationGroup();
	}

	public String getFieldToBeCustomValidated() {
		return fieldToBeCustomValidated;
	}

	public void setFieldToBeCustomValidated(final String fieldToBeCustomValidated) {
		this.fieldToBeCustomValidated = fieldToBeCustomValidated;
	}
}
