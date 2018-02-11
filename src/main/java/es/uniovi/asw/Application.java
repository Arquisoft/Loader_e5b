package es.uniovi.asw;

import java.io.IOException;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class Application {

	public static void main(String... args) {
		try {

			// ---EJECUCION POR LINEA DE COMANDOS---
			// new Application().run((String) args[0], (String) args[1]);

			// ---EJECUCION PARA PRUEBAS---
			new Application().run("texto", "src/test/resources/testAgents.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String formato, String filePath) throws IOException, BusinessException {
		Loader loader = new Loader(formato, filePath);
		loader.readList();
	}

}
