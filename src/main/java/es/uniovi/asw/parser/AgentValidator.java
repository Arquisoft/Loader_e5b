package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.parser.reader.CSVReader;

public class AgentValidator {

	/**
	 * Método para validar los agentes de la lista que se pasa por parametro
	 * @param inputAgents
	 * @param kindFilepath
	 * @return
	 * @throws IOException
	 */
	public static List<Agent> getValidAgents(List<Agent> inputAgents, String kindFilepath) throws IOException {

		Map<String, String> kindMap = new CSVReader().readTypes(kindFilepath);
		ArrayList<Agent> validAgents = new ArrayList<Agent>();
		
		for(Agent agent: inputAgents){
			if(checkAgentFields(agent) && checkAgentKindFields(agent, kindMap))
				validAgents.add(agent);
		}
		return validAgents;
	}

	
	/**
	 * Comprueba la consistencia de los agentes
	 * Si es un agente tipo sensor debe llevar localizacion
	 * @param agent
	 * @param kindMap
	 * @return
	 */
	private static boolean checkAgentKindFields(Agent agent, Map<String, String> kindMap) {

		if (!kindMap.containsKey(agent.getTipo()))
			return false;
		if (kindMap.get(agent.getTipo()).equals("Sensor") && agent.getLocalizacion().equals(""))
			return false;
		return true;
	}

	
	/**
	 * Comprueba campos vacios
	 * @param agent
	 * @return
	 */
	public static boolean checkAgentFields(Agent agent) {

		if (agent.getIdentificador() == "")
			return false;
		if (agent.getTipo() == "")
			return false;
		return true;
	}
}
