package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public interface AgentService {

	void insertAgent(Agent agent) throws BusinessException;

	boolean isAgentInDatabase(Agent agent) throws BusinessException;
	
	List<Agent> findAllAgents() throws BusinessException;

	void deleteAllAgents(List<Agent> agents) throws BusinessException;
	
}