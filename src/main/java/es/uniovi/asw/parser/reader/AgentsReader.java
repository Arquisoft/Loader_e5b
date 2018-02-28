package es.uniovi.asw.parser.reader;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Agent;

public interface AgentsReader {

	/**
	 * Metodo para sacar los agentes del excel
	 * @param filePath, ruta del archivo en cuestión
	 * @return lista de agentes
	 * @throws IOException
	 */
	List<Agent> readAgents(String filePath) throws IOException;

}
