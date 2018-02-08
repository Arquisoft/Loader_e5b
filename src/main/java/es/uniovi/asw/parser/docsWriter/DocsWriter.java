package es.uniovi.asw.parser.docsWriter;

import java.io.IOException;

import es.uniovi.asw.model.Agent;

public interface DocsWriter {
	void write(Agent email) throws IOException;
}//comentario para prueba
