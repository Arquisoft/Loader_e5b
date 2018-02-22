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
			cargarBaseDatos();
			new Application().run("texto", "src/test/resources/testAgents.txt", "src/test/resources/testAgentKind.csv");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String formato, String filepath, String kindFilepath) throws IOException, BusinessException {
		Loader loader = new Loader(formato, filepath, kindFilepath);
		loader.readList();
	}
	
	public static void cargarBaseDatos() {
		try {
			Runtime.getRuntime().exec("cmd /c start BD\\data\\startup4.bat");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
