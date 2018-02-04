package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteAllCitizens implements Command {
	
	List<Agent> citizens;

	public DeleteAllCitizens(List<Agent> citizens) {
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
