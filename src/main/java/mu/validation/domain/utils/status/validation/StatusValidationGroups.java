package mu.validation.domain.utils.status.validation;

import javax.validation.groups.Default;

public interface StatusValidationGroups {

	interface DraftGroup extends Default{

	}

	interface SignedGroup extends DraftGroup {

	}

	interface ActiveGroup extends SignedGroup {

	}

	interface CanceledGroup extends Default{

	}

	interface EndedGroup extends ActiveGroup{

	}

	interface DishonoredGroup extends ActiveGroup{

	}



}
