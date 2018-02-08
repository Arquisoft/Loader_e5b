package es.uniovi.asw.parser.docsWriter;

import java.io.FileOutputStream;
import java.io.IOException;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.util.Writer;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;*/

public class PdfWriterImpl implements DocsWriter{
private static final String fileName = "src/test/resources/emails.txt";
	//modificar tipo de documento al correspondiente

	@Override
	public void write(Agent agent) throws IOException {
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
		documento.add(new Paragraph("Usuario: "+agent.getNombre()+". Contrasena: "+agent.getContrasena()));
*/
		
	}
}
