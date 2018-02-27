package es.uniovi.asw.parser.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Agent;

public class ExcelAgentsReader implements AgentsReader {

	@Override
	public List<Agent> readAgents(String filePath) throws IOException {
		
		
		List<Agent> agents = new ArrayList<Agent>();
		
		try {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		iterator.next(); // Para saltar la primera fila de titulos

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Agent agent = new Agent();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					agent.setNombre(nextCell.getStringCellValue());
					break;
				case 1:
					agent.setLocalizacion(nextCell.getStringCellValue());
					break;
				case 2:
					agent.setEmail(nextCell.getStringCellValue());
					break;
				case 3:
					agent.setIdentificador(String.valueOf(Double.valueOf(nextCell.getNumericCellValue()).intValue()));
					break;
				case 4:
					agent.setTipo(String.valueOf(Double.valueOf(nextCell.getNumericCellValue()).intValue()));
					break;
				default:
					break;
				}
			}
			agent.setContrasena(agent.getNombre() + "123");
			agents.add(agent);
		}
		workbook.close();
		inputStream.close();

		return agents;
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}

		catch(IOException e) {
			System.out.println("Error en la lectura del archivo");
		}catch(Exception e) {
			System.out.println("error capturado con Exception");
		}
		return null;
	}
	

}