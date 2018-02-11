package es.uniovi.asw.model.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import es.uniovi.asw.parser.reader.CSVReader;

public class Type {
	
	Map<String,String> listaTipos;
	
	public Type(String path) {
		CSVReader loader= new CSVReader();
		try {
			Map<String, String> mapa= loader.readTypes(path);
			this.listaTipos= mapa;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Map<String, String> getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(Map<String, String> listaTipos) {
		this.listaTipos = listaTipos;
	}
	
	public String getNombre(String codigo) {
		return listaTipos.get(codigo);
	}
	
	public String getCodigo(String nombre) {
		for (Entry<String, String> entry : listaTipos.entrySet()) {
            if (entry.getValue().equals(nombre)) {
               return entry.getKey();
            }
        }
		return null;
	}
	
	

}
