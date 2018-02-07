package es.uniovi.asw.business.impl.citizen;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.AgentFinder;

public class IsAgentInDatabase implements Command {

	private Agent agent;

	public IsAgentInDatabase(Agent citizen) {
		this.agent = citizen;
	}

	public Object execute() {
		return AgentFinder.isInDatabase(agent);
	}
}
