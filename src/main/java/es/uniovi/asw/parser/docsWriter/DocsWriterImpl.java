package es.uniovi.asw.parser.docsWriter;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.util.Writer;

public class DocsWriterImpl implements DocsWriter{
private static final String fileName = "src/test/resources/documentoword.docx";
	//modificar tipo de documento al correspondiente
	@Override
	public void write(Agent agent) throws IOException {
		//Writer.write(fileName, email);
		String tituloDocumento = "Bienvenido estos son tus datos";
		String usuario = agent.getIdentificador();
		String contrasena=agent.getContrasena();
		
		//Creamos el documento
		XWPFDocument documento = new XWPFDocument();
		        
		//Declaramos el titulo y le asignamos algunas propiedades
		XWPFParagraph titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		        
		//Declaramos el parrafo y le asignamos algunas propiedades
		XWPFParagraph parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		//Para el titulo
		XWPFRun r1 = titulo_doc.createRun();
		r1.setBold(true);
		r1.setText(tituloDocumento);
		r1.setFontFamily("Arial");
		r1.setFontSize(14);
		r1.setTextPosition(10);
		r1.setUnderline(UnderlinePatterns.SINGLE);
		        
		//Para el parrafo
		XWPFRun r2 = parrafo.createRun();
		r2.setText("usuario: "+usuario+". Contraseña: "+contrasena);
		r2.setFontSize(12);
		r2.addCarriageReturn();
		
		try {
		    FileOutputStream word = new FileOutputStream(tituloDocumento+".docx");
		    documento.write(word);
		    word.close();
		    //Desktop.getDesktop().open(tituloDocumento+".docx");
		} catch (FileNotFoundException ex) {
		    //Logger.getLogger(JF_Validar.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("filenotfoundexception");
		} catch (IOException ex) {
		    //Logger.getLogger(JF_Validar.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("ioexception");
		}
		
		
	}//cambiod
}
