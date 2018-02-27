package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CSVReader {

	/**
	 * Se lee un archivo csv con los tipos de agentes y sus respectivos códigos numéricos
	 * y se devuelve un map con ellos.
	 * @param filePath Path del archivo .csv
	 * @return Map con los tipos de Agent
	 * @throws IOException
	 */
	public Map<String,String> readTypes(String filePath) throws IOException {
		String linea = "";
		String[] datos = null;
		Map<String,String> mapa = new HashMap<String,String>();
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(filePath));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datos = linea.split(",");

				mapa.put(datos[0], datos[1]);
			}
			fichero.close();
		}catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}

		catch(IOException e) {
			System.out.println("Error en la lectura del archivo");
		}
		catch (Exception e) {
			System.err.println("Error capturado mediante Excepcion");
		}
		return mapa;
	}

}
