package es.uniovi.asw.business.impl.citizen;

import es.uniovi.asw.business.impl.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.persistence.util.Jpa;

public class AddAgent implements Command {

	private Agent citizen;

	public AddAgent(Agent citizen) {
		this.citizen = citizen;
	}

	public Object execute() {
		
		Jpa.getManager().persist(citizen);
		
		return citizen;
	}

}
