package mu.validation.domain.utils.status;

import mu.validation.domain.utils.status.validation.StatusValidationGroups;

public enum ContractStatus {

	DRAFT(StatusValidationGroups.DraftGroup.class) {
		@Override
		public void sign(ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(SIGNED);
		}

		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}
	},

	SIGNED(StatusValidationGroups.SignedGroup.class) {
		@Override
		public void dishonor(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(DISHONORED);
		}

		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}

	},

	ACTIVE(StatusValidationGroups.ActiveGroup.class){

		@Override
		public void dishonor(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(DISHONORED);
		}

		@Override
		public void end(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(ENDED);
		}

	},

	CANCELED(StatusValidationGroups.CanceledGroup.class),
	ENDED(StatusValidationGroups.EndedGroup.class),

	DISHONORED(StatusValidationGroups.DraftGroup.class) {
		@Override
		public void cancel(final ContractStatusContext contractStatusContext) {
			contractStatusContext.setContractStatus(CANCELED);
		}
	};

	private final Class<?> validationGroup;

	private ContractStatus(Class<?> validationGroup){
		this.validationGroup = validationGroup;
	}

	public Class<?> getValidationGroup() {
		return validationGroup;
	}

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
