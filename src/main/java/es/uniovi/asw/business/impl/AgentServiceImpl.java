package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.business.impl.agent.AddAgent;
import es.uniovi.asw.business.impl.agent.DeleteAllAgents;
import es.uniovi.asw.business.impl.agent.FindAllAgents;
import es.uniovi.asw.business.impl.agent.IsAgentInDatabase;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public class AgentServiceImpl implements AgentService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertAgent(Agent agent) throws BusinessException {
		executor.execute(new AddAgent( agent ));
	}
	
	@Override
	public boolean isAgentInDatabase(Agent agent) throws BusinessException {
		return (Boolean)executor.execute(new IsAgentInDatabase( agent ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> findAllAgents() throws BusinessException {
		return (List<Agent>) executor.execute(new FindAllAgents());
	}

	@Override
	public void deleteAllAgents(List<Agent> agents) throws BusinessException {
		executor.execute(new DeleteAllAgents(agents));
	}
}
