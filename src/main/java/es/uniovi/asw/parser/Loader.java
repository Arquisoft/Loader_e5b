/*<<<<<<< HEAD
package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.emailWriter.EmailWriter;
import es.uniovi.asw.parser.emailWriter.TxtEmailWriter;
import es.uniovi.asw.parser.reader.AgentsReader;
import es.uniovi.asw.parser.reader.ExcelAgentsReader;
import es.uniovi.asw.parser.reader.TextAgentsReader;
import es.uniovi.asw.reportWriter.LogWriter;

public class Loader {

	private String formato;
	private String filePath;

	public Loader(String formato, String filePath) {
		this.formato = formato;
		this.filePath = filePath;
	}

	public void readList() throws IOException, BusinessException {
		
		List<Agent> citizens = readCitizens(formato, filePath);

		CitizenService citizenService = ServicesFactory.getCitizenService();

		printCitizens(citizens, filePath);

		for (Agent citizen : citizens) {
			if (!citizenService.isCitizenInDatabase(citizen)) {
				sendEmail(citizen, new TxtEmailWriter());
				citizenService.insertCitizen(citizen);
			} else {
				String mensaje = "El usuario " + citizen.getId()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	public List<Agent> readCitizens(String formato, String filePath) throws IOException {
		return getReader(formato).readCitizens(filePath);
	}

	private void sendEmail(Agent citizen, EmailWriter... writers)
			throws IOException {
		String email = "To "
				+ citizen.getEmail()
				+ ":\nSaludos "
				+ citizen.getNombre()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ citizen.getId();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

	}

	
	private AgentsReader getReader(String formato) {
		if ("excel".equals(formato)) {
			return new ExcelAgentsReader();
		} else if ("texto".equals(formato)) {
			return new TextAgentsReader();
		}
		return null;
	}

	public String getFormato() {
		return formato;
	}

	public String getFilePath() {
		return filePath;
	}
	
	
	
	private void printCitizens(List<Agent> citizens, String filePath) {
		System.out.println("Estos son los usuarios presentes en el fichero "
				+ filePath + ":");
		for (Agent citizen : citizens) {
			System.out.println(citizen);
		}
	}
	

}
=======*/
package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.emailWriter.EmailWriter;
import es.uniovi.asw.parser.emailWriter.TxtEmailWriter;
import es.uniovi.asw.parser.reader.AgentsReader;
import es.uniovi.asw.parser.reader.ExcelAgentsReader;
import es.uniovi.asw.parser.reader.TextAgentsReader;
import es.uniovi.asw.reportWriter.LogWriter;

public class Loader {

	private String formato;
	private String filePath;

	public Loader(String formato, String filePath) {
		this.formato = formato;
		this.filePath = filePath;
	}

	public void readList() throws IOException, BusinessException {
		
		List<Agent> agents = readAgents(formato, filePath);

		AgentService agentService = ServicesFactory.getAgentService();

		printAgents(agents, filePath);

		for (Agent agent : agents) {
			if (!agentService.isAgentInDatabase(agent)) {
				sendEmail(agent, new TxtEmailWriter());
				agentService.insertAgent(agent);
			} else {
				String mensaje = "El usuario " + agent.getIdentificador()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}

	public List<Agent> readAgents(String formato, String filePath) throws IOException {
		return getReader(formato).readAgents(filePath);
	}

	private void sendEmail(Agent agent, EmailWriter... writers)
			throws IOException {
		String email = "To "
				+ agent.getEmail()
				+ ":\nSaludos "
				+ agent.getNombre()
				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
				+ agent.getIdentificador();
		for (EmailWriter writer : writers) {
			writer.write(email);
		}

	}

	/**
	 * Crea y devuelve el reader adecuado
	 */
	private AgentsReader getReader(String formato) {
		if ("excel".equals(formato)) {
			return new ExcelAgentsReader();
		} else if ("texto".equals(formato)) {
			return new TextAgentsReader();
		}
		return null;
	}

	public String getFormato() {
		return formato;
	}

	public String getFilePath() {
		return filePath;
	}
	
	
	
	private void printAgents(List<Agent> agents, String filePath) {
		System.out.println("Estos son los agentes presentes en el fichero "
				+ filePath + ":");
		for (Agent agent : agents) {
			System.out.println(agent);
		}
	}
	

}
//>>>>>>> branch 'master' of https://github.com/Arquisoft/Loader_e5b.git
