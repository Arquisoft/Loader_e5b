package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.business.impl.citizen.AddAgent;
import es.uniovi.asw.business.impl.citizen.DeleteAllAgents;
import es.uniovi.asw.business.impl.citizen.FindAllAgents;
import es.uniovi.asw.business.impl.citizen.IsAgentInDatabase;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public class AgentServiceImpl implements AgentService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertAgent(Agent citizen) throws BusinessException {
		executor.execute(new AddAgent( citizen ));
	}
	
	@Override
	public boolean isAgentInDatabase(Agent citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsAgentInDatabase( citizen ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> findAllAgents() throws BusinessException {
		return (List<Agent>) executor.execute(new FindAllAgents());
	}

	@Override
	public void deleteAllAgents(List<Agent> citizens) throws BusinessException {
		executor.execute(new DeleteAllAgents(citizens));
	}
}
