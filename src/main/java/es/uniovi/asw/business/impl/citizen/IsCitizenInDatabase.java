package es.uniovi.asw.business.impl.citizen;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.CitizenFinder;

public class IsCitizenInDatabase implements Command {

	private Agent citizen;

	public IsCitizenInDatabase(Agent citizen) {
		this.citizen = citizen;
	}

	public Object execute() {
		return CitizenFinder.isInDatabase(citizen);
	}
}
