package es.uniovi.asw.parser.docsWriter;

import java.io.IOException;

import es.uniovi.asw.model.Agent;

public class PdfWriterImpl implements DocsWriter{
private static final String fileName = "src/test/resources/documentopdf.pdf";
	//modificar tipo de documento al correspondiente

	@Override
	public void write(Agent agent) throws IOException {
		
		//COMENTAR CON EL EQUIPO INTRODUCCION LIBRERIA PARA LA ESCRITURA EN PDF (ocupa mas espacio).
		//una vez hecho, se descomenta esto y ya estaria implementado
		
		/*
		//Writer.write(fileName, email);
		
		// Se crea el documento
		Document documento = new Document();

		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		documento.open();
		
		
		
		documento.add(new Paragraph("Bienvenido. A continuacion te facilitamos tus datos"));
		documento.add(new Paragraph("Usuario: "+agent.getIdentificador()+". Contrasena: "+agent.getContrasena()));
*/
		
	}
}
