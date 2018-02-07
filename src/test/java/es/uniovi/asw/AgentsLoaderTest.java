package es.uniovi.asw;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

import es.uniovi.asw.business.CitizenService;
import es.uniovi.asw.conf.ServicesFactory;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;

public class AgentsLoaderTest {

    @Test
    public void testLoadFromTxt() throws IOException, BusinessException {
    	
    	Loader loader = new Loader("texto", "src/test/resources/testAgents.txt");
		List<Agent> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		
		Agent juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		assertEquals(juan.getLocalizacion(), "0 1");
		assertEquals(juan.getId(), "0");
		assertEquals(juan.getTipo(), "1");
		//assertEquals(juan.getContrasena(), "Juan Torres Pardo123");
		System.out.println(juan.getContrasena());
		
    }
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException {
		Loader loader = new Loader("excel", "src/test/resources/testAgents.xlsx");
		List<Agent> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		
		Agent juan = citizens.get(0);
		assertEquals(juan.getNombre(), "Juan Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		assertEquals(juan.getLocalizacion(), "0 1");
		assertEquals(juan.getId(), "0");
		assertEquals(juan.getTipo(), "1");
		//assertEquals(juan.getContrasena(), "Juan Torres Pardo123");
		System.out.println(juan.getContrasena());
		
    }
    
    
    @Test
    public void testBBDD() throws IOException, BusinessException { 
    	
    	CitizenService citizenService = ServicesFactory.getCitizenService();
    	List<Agent> citizens = citizenService.findAllCitizens();
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
    
}
