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
				//generarDocs(agent,new DocsWriterImpl(),new PdfWriterImpl());
				agentService.insertAgent(agent);
			} else {
				String mensaje = "El usuario " + agent.getIdentificador()
						+ " ya está registrado.";
				LogWriter.write(mensaje);
			}
		}
	}
	
//	public void generarDocs(Agent agent,DocsWriter...writers) throws IOException {
//		String email = "To "
//				+ agent.getEmail()
//				+ ":\nSaludos "
//				+ agent.getNombre()
//				+ ", le informamos de que ha sido registrado correctamente en el sistema de participación ciudadana.\nSu nombre de usuario es: "
//				+ agent.getIdentificador();
//		for (DocsWriter writer : writers) {
//			writer.write(agent);
//		}
//	}

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
