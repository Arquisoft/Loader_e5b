package es.uniovi.asw.parser.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.uniovi.asw.model.Agent;

public class TextAgentsReader implements AgentsReader {

	@Override
	public List<Agent> readAgents(String filePath) throws IOException {
		String linea = "";
		String[] datosAgent = null;
		List<Agent> agents = new ArrayList<Agent>();
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(filePath));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosAgent = linea.split(";");
				
				Agent agent = new Agent(datosAgent[3],datosAgent[0],datosAgent[1],
						datosAgent[2],datosAgent[4]);
				// Y su contraseña es nombre + 123
				agent.setContrasena(crearContrasena());
				agents.add(agent);
			}
			fichero.close();
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}

		catch(IOException e) {
			System.out.println("Error en la lectura del archivo");
		}
		
		
		
		catch (Exception e) {
			System.err.println("Error al parsear desde txt");
		}
		return agents;
	}
	
	private String crearContrasena() {
		String pass="";
		String opciones="QWERTYUIOPÑLKJHGFDSAZXCVBNMmnbvcxzasdfghjklñpoiuytrewq01234567890";
		for(int i=0;i<6;i++) {
			Random r= new Random();
			int x=r.nextInt(opciones.length());
			pass+=Character.toString(opciones.charAt(x));
		}
		return pass;
		
	}

}