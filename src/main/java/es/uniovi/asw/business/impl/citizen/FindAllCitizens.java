package es.uniovi.asw.business.impl.citizen;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.CitizenFinder;

public class FindAllCitizens implements Command {
	
	public List<Agent> execute() {
		return CitizenFinder.findAll();	
	}
}
