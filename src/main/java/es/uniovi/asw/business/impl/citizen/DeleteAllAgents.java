/*<<<<<<< HEAD
package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteAllAgents implements Command {
	
	List<Agent> citizens;

	public DeleteAllAgents(List<Agent> citizens) {
		this.citizens = citizens;
	}

	@Override
	public Object execute() throws BusinessException {
		
		for(Agent citizen : citizens) {
			Agent citizenPersistent = Jpa.getManager().find(Agent.class, citizen.getId());
			Jpa.getManager().remove(citizenPersistent);
		}
		
		return null;
	}
	
}
=======*/
package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteAllAgents implements Command {

	List<Agent> agents;

	public DeleteAllAgents(List<Agent> agents) {
		this.agents = agents;
	}

	@Override
	public Object execute() throws BusinessException {

		for (Agent agent : agents) {
			Agent agentPersistent = Jpa.getManager().find(Agent.class, agent.getIdentificador());
			Jpa.getManager().remove(agentPersistent);
		}

		return null;
	}

}
//>>>>>>> branch 'master' of https://github.com/Arquisoft/Loader_e5b.git
