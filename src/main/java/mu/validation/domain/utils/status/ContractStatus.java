package mu.validation.domain.utils.status;

public enum ContractStatus {

	DRAFT {
		@Override
		public void sign(ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(SIGNED);
		}

		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}
	},

	SIGNED {
		@Override
		public void dishonor(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(DISHONORED);
		}

		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}

	},

	ACTIVE{

		@Override
		public void dishonor(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(DISHONORED);
		}

		@Override
		public void end(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(ENDED);
		}

	},

	CANCELED,
	ENDED,

	DISHONORED {
		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}
	};

	public void sign(ContractStatusContext contractStatusContext) {
		throw new IllegalStateException("This state [" + this.name() + "] does not allow to sign");
	}

	public void aprove(ContractStatusContext contractStatusContext) {
		throw new IllegalStateException("This state [" + this.name() + "] does not allow to approve");
	}

	public void cancel(ContractStatusContext contractStatusContext) {
		throw new IllegalStateException("This state [" + this.name() + "] cannot be canceled");
	}

	public void end(ContractStatusContext contractStatusContext) {
		throw new IllegalStateException("This state [" + this.name() + "] does not allow to end");
	}

	public void dishonor(ContractStatusContext contractStatusContext) {
		throw new IllegalStateException("This state [" + this.name() + "] does not allow to dishonor");
	}

}
