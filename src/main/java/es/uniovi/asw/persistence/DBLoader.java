package es.uniovi.asw.persistence;

import java.io.IOException;

public class DBLoader {
	
	static Process p;
	
	public static void cargarBaseDatos() {
		try {
			p = Runtime.getRuntime().exec("cmd /c start BD\\data\\startup3.bat");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void cerrarBaseDatos() {
		if(p!=null && p.isAlive()) {
			p.destroy();
		}
	} 
}
