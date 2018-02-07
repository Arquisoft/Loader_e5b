package es.uniovi.asw.business.impl.citizen;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.AgentFinder;

public class IsAgentInDatabase implements Command {

	private Agent citizen;

	public IsAgentInDatabase(Agent citizen) {
		this.citizen = citizen;
	}

	public Object execute() {
		return AgentFinder.isInDatabase(citizen);
	}
}
