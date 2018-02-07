package es.uniovi.asw;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class CitizensLoaderTest {

    @Test
    public void testLoadFromTxt() throws IOException, BusinessException {
    	
    	Loader loader = new Loader("texto", "src/test/resources/testAgents.txt");
		List<Agent> citizens = loader.readAgents(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		
		Agent juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		assertEquals(juan.getLocalizacion(), "0 1");
		assertEquals(juan.getIdentificador(), "0");
		assertEquals(juan.getTipo(), "1");
		assertEquals(juan.getContrasena(), "Juan Torres Pardo123");
		
		Agent ana = citizens.get(2);
		assertEquals(ana.getNombre(), "Ana Torres Pardo");
		assertEquals(ana.getEmail(), "ana@example.com");
		assertEquals(ana.getLocalizacion(), "");
		assertEquals(ana.getIdentificador(), "2");
		assertEquals(ana.getTipo(), "1");
		assertEquals(ana.getContrasena(), "Ana Torres Pardo123");
		
		Agent entidad1 = citizens.get(3);
		assertEquals(entidad1.getNombre(), "Entidad 01");
		assertEquals(entidad1.getEmail(), "E1@example.com");
		assertEquals(entidad1.getLocalizacion(), "0 1");
		assertEquals(entidad1.getIdentificador(), "3");
		assertEquals(entidad1.getTipo(), "2");
		assertEquals(entidad1.getContrasena(), "Entidad 01123");
		
		Agent entidad2 = citizens.get(4);
		assertEquals(entidad2.getNombre(), "Entidad 02");
		assertEquals(entidad2.getEmail(), "E2@example.com");
		assertEquals(entidad2.getLocalizacion(), "");
		assertEquals(entidad2.getIdentificador(), "4");
		assertEquals(entidad2.getTipo(), "2");
		assertEquals(entidad2.getContrasena(), "Entidad 02123");
		
		Agent sensor1 = citizens.get(5);
		assertEquals(sensor1.getNombre(), "Sensor 01");
		assertEquals(sensor1.getEmail(), "S1@example.com");
		assertEquals(sensor1.getLocalizacion(), "2 1");
		assertEquals(sensor1.getIdentificador(), "5");
		assertEquals(sensor1.getTipo(), "3");
		assertEquals(sensor1.getContrasena(), "Sensor 01123");
		
		Agent sensor2 = citizens.get(6);
		assertEquals(sensor2.getNombre(), "Sensor 02");
		assertEquals(sensor2.getEmail(), "S2@example.com");
		assertEquals(sensor2.getLocalizacion(), "3 0");
		assertEquals(sensor2.getIdentificador(), "6");
		assertEquals(sensor2.getTipo(), "3");
		assertEquals(sensor2.getContrasena(), "Sensor 02123");
		
		
		
		
    }
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException {
		Loader loader = new Loader("excel", "src/test/resources/testAgents.xlsx");
		List<Agent> citizens = loader.readAgents(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		
		Agent juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		assertEquals(juan.getLocalizacion(), "0 1");
		assertEquals(juan.getIdentificador(), "0");
		assertEquals(juan.getTipo(), "1");
		assertEquals(juan.getContrasena(), "Juan Torres Pardo123");
		
		Agent ana = citizens.get(2);
		assertEquals(ana.getNombre(), "Ana Torres Pardo");
		assertEquals(ana.getEmail(), "ana@example.com");
		assertEquals(ana.getLocalizacion(), null);
		assertEquals(ana.getIdentificador(), "2");
		assertEquals(ana.getTipo(), "1");
		assertEquals(ana.getContrasena(), "Ana Torres Pardo123");
		
		Agent entidad1 = citizens.get(3);
		assertEquals(entidad1.getNombre(), "Entidad 01");
		assertEquals(entidad1.getEmail(), "E1@example.com");
		assertEquals(entidad1.getLocalizacion(), "0 1");
		assertEquals(entidad1.getIdentificador(), "3");
		assertEquals(entidad1.getTipo(), "2");
		assertEquals(entidad1.getContrasena(), "Entidad 01123");
		
		Agent entidad2 = citizens.get(4);
		assertEquals(entidad2.getNombre(), "Entidad 02");
		assertEquals(entidad2.getEmail(), "E2@example.com");
		assertEquals(entidad2.getLocalizacion(), null);
		assertEquals(entidad2.getIdentificador(), "4");
		assertEquals(entidad2.getTipo(), "2");
		assertEquals(entidad2.getContrasena(), "Entidad 02123");
		
		Agent sensor1 = citizens.get(5);
		assertEquals(sensor1.getNombre(), "Sensor 01");
		assertEquals(sensor1.getEmail(), "S1@example.com");
		assertEquals(sensor1.getLocalizacion(), "2 1");
		assertEquals(sensor1.getIdentificador(), "5");
		assertEquals(sensor1.getTipo(), "3");
		assertEquals(sensor1.getContrasena(), "Sensor 01123");
		
		Agent sensor2 = citizens.get(6);
		assertEquals(sensor2.getNombre(), "Sensor 02");
		assertEquals(sensor2.getEmail(), "S2@example.com");
		assertEquals(sensor2.getLocalizacion(), "3 0");
		assertEquals(sensor2.getIdentificador(), "6");
		assertEquals(sensor2.getTipo(), "3");
		assertEquals(sensor2.getContrasena(), "Sensor 02123");
		
    }
    /*
    @Test
    public void testBBDD() throws IOException, BusinessException { 
    	
    	CitizenService citizenService = ServicesFactory.getCitizenService();
    	List<Citizen> citizens = citizenService.findAllCitizens();
    	citizenService.deleteAllCitizens(citizens);
    	
    	Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
    	
    	//Load and send emails to all of the new Citizens
		loader.readList();
		citizens = citizenService.findAllCitizens();
		assertEquals(citizens.size(), 3);
		
		//We load all of them again, but all of them are already in the database, so we write the log file
		loader.readList();
		citizens = citizenService.findAllCitizens();
		assertEquals(citizens.size(), 3);
		
		citizenService.deleteAllCitizens(citizens);	
    }
    */ 
}
