package mu.validation.domain;

import java.util.Date;
import javax.validation.constraints.NotNull;
import mu.validation.domain.utils.status.ContractStatus;
import mu.validation.domain.utils.status.ContractStatusContext;
import mu.validation.domain.utils.Person;

public class Contract {

	private Person farmer;

	private ContractStatusContext statusContext;

	@NotNull
	private Date startDate;

	private Date approveDate;

	private Date endDate;

	protected Contract() {
		statusContext = new ContractStatusContext();
	}

	public Contract(final Person farmer, final ContractStatusContext statusContext) {
		this.farmer = farmer;
		this.statusContext = statusContext;
	}

	public void sign() {
		statusContext.sign();
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

	public Person getFarmer() {
		return farmer;
	}

	public void setFarmer(final Person farmer) {
		this.farmer = farmer;
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
}
