package es.uniovi.asw.parser.docsWriter;

import java.io.IOException;

import es.uniovi.asw.model.Agent;

public interface DocsWriter {
	
	
	/**
	 * Metodo para crear documentos word con los datos del agente. En el que se le proporcionará su usuario y contraseña
	 * @param email, email del agente
	 * @throws IOException
	 */
	void write(Agent email) throws IOException;
	
	
}//comentario para prueba
