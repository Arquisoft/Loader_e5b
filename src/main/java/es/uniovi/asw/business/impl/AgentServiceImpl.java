package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.business.impl.citizen.AddAgent;
import es.uniovi.asw.business.impl.citizen.DeleteAllAgents;
import es.uniovi.asw.business.impl.citizen.FindAllAgents;
import es.uniovi.asw.business.impl.citizen.IsAgentInDatabase;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public class AgentServiceImpl implements CitizenService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertCitizen(Agent citizen) throws BusinessException {
		executor.execute(new AddAgent( citizen ));
	}
	
	@Override
	public boolean isCitizenInDatabase(Agent citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsAgentInDatabase( citizen ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> findAllCitizens() throws BusinessException {
		return (List<Agent>) executor.execute(new FindAllAgents());
	}

	@Override
	public void deleteAllCitizens(List<Agent> citizens) throws BusinessException {
		executor.execute(new DeleteAllAgents(citizens));
	}
}
