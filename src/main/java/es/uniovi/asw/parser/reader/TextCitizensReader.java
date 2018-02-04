package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Agent;

public class TextCitizensReader implements CitizensReader {

	@Override
	public List<Agent> readCitizens(String filePath) throws IOException {
		String linea = "";
		String[] datosAgent = null;
		List<Agent> newCitizens = new ArrayList<Agent>();
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(filePath));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosAgent = linea.split(";");
				
				Agent agent = new Agent(datosAgent[3],datosAgent[0],datosAgent[1],
						datosAgent[2],datosAgent[4]);
				// Y su contraseña es nombre + 123
				agent.setContrasena(agent.getNombre() + "123");
				newCitizens.add(agent);
			}
			fichero.close();
		} catch (Exception e) {
			System.err.println("Error al parsear desde txt");
		}
		return newCitizens;
	}

}
