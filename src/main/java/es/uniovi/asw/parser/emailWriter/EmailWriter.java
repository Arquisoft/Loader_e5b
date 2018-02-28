package es.uniovi.asw.parser.emailWriter;

import java.io.IOException;

public interface EmailWriter {
	/**
	 * 
	 * @param email
	 * @throws IOException
	 */
	void write(String email) throws IOException;
}
