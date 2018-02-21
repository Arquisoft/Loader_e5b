package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.parser.reader.CSVReader;

public class AgentValidator {

	public static List<Agent> getValidAgents(List<Agent> inputAgents) {

		//FILEPATH HARDCODED hay que decidir como procedemos con el path del fichero de tipos
		
		Map<String, String> kindMap = new HashMap<String, String>();
		try {
			kindMap = new CSVReader().readTypes("src/test/resources/testAgentKind.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Agent> validAgents = new ArrayList<Agent>();
		
		for(Agent agent: inputAgents){
			if(checkAgentFields(agent) && checkAgentKindFields(agent, kindMap))
				validAgents.add(agent);
		}
		return validAgents;
	}

	private static boolean checkAgentKindFields(Agent agent, Map<String, String> kindMap) {

		if (!kindMap.containsKey(agent.getTipo()))
			return false;
		if (kindMap.get(agent.getTipo()).equals("Sensor") && agent.getLocalizacion().equals(""))
			return false;

		return true;
	}

	public static boolean checkAgentFields(Agent agent) {

		if (agent.getIdentificador() == "")
			return false;
		if (agent.getTipo() == "")
			return false;

		return true;
	}
}
