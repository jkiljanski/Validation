package mu.validation.domain.utils.status;

public class ContractStatusContext {

	private ContractStatus contractStatus;

	public ContractStatusContext() {
		this.contractStatus = ContractStatus.DRAFT;
	}

	public void sign() {
		contractStatus.sign(this);
	}

	public void cancel() {
		contractStatus.cancel(this);
	}

	public void end() {
		contractStatus.end(this);
	}

	public void dishonor() {
		contractStatus.dishonor(this);
	}

	void setContractStatus(final ContractStatus state) {
		this.contractStatus = contractStatus;
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}
}
