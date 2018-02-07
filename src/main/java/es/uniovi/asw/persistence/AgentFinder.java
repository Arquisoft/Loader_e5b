package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.util.Jpa;

public class AgentFinder {

	public static boolean isInDatabase(Agent agent) {
		List<Agent> lista = Jpa
				.getManager()
				.createQuery("select a from AGENT a where a.identificador = ?",
						Agent.class).setParameter(1, agent.getIdentificador())
				.getResultList();
		return !lista.isEmpty();
	}

	public static List<Agent> findAll() {
		return Jpa.getManager()
				.createQuery("select a from AGENT a", Agent.class)
				.getResultList();
	}
}
