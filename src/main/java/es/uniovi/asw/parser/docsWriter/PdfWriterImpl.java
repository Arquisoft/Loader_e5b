package es.uniovi.asw.parser.docsWriter;

import java.io.IOException;

import es.uniovi.asw.model.util.Writer;

public class PdfWriterImpl implements DocsWriter{
private static final String fileName = "src/test/resources/emails.txt";
	//modificar tipo de documento al correspondiente

	@Override
	public void write(String email) throws IOException {
		Writer.write(fileName, email);
	}
}
