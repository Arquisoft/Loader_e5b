package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public interface CitizenService {

	void insertCitizen(Agent citizen) throws BusinessException;

	boolean isCitizenInDatabase(Agent citizen) throws BusinessException;
	
	List<Agent> findAllCitizens() throws BusinessException;

	void deleteAllCitizens(List<Agent> citizens) throws BusinessException;
	
}
