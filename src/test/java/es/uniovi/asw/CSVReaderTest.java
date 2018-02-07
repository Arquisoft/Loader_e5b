package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.Loader;
import es.uniovi.asw.parser.reader.CSVReader;

public class CSVReaderTest {

	@Test
    public void testLoadFromCSV() throws IOException, BusinessException {
		CSVReader loader= new CSVReader();
		Map<String, String> tipos = loader.readTypes("src/test/resources/testAgentKind.csv");
		assertEquals(3, tipos.size());
		
		assertEquals(true,tipos.containsKey("1"));
		assertEquals(true,tipos.containsKey("2"));
		assertEquals(true,tipos.containsKey("3"));
		assertEquals(false,tipos.containsKey("4"));
		
		assertEquals(tipos.get("1"), "Person");
		assertEquals(tipos.get("2"), "Entity");
		assertEquals(tipos.get("3"), "Sensor");
		
		
		
    }

}
