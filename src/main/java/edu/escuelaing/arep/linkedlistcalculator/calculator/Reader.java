package edu.escuelaing.arep.linkedlistcalculator.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.escuelaing.arep.linkedlistcalculator.linkedlist.LinkedList;

/**
 * Clase encargada de comunicarse con la interfaz para que realice el conteo
 * correspondiente
 * 
 * @author Eduard Jimenez
 */
public class Reader {

	public Reader() {

	}

	/**
	 * Reads the file line per line adding each line (number) to a linkedList for
	 * calcultes mean and standar deviation
	 * 
	 * @param ruta File's path.
	 * @throws java.io.IOException If the file's path is not found.
	 */
	public String[] leerArchivo(String ruta) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path archivo = Paths.get(ruta);
		LinkedList lista = new LinkedList();
		try (BufferedReader lector = Files.newBufferedReader(archivo, charset)) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				Double element = Double.parseDouble(linea);
				lista.add(element);
			}
			Calculator calculator = new Calculator();
			Double mean = calculator.calculateMean(lista);
			Double standarDeviation = calculator.calculateStandarDeviation(lista);					
			String[] results = {"Mean: " + mean,"Standar deviation: " + standarDeviation};			
			return results;
		} catch (IOException e) {
			throw new IOException("El archivo no existe", e);
		}

	}

	public String[] prepareDataToReturn(String[] lista) {
		writeFile(lista);
		try {
			return leerArchivo("test_file.txt");
		} catch (IOException e) {
			e.printStackTrace();
			return null;			
		}
	}

	public void writeFile(String[] lista) {		
		File f;
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter pwr;
		String name = "test_file.txt";
		try {			
			f = new File(name);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			pwr = new PrintWriter(bw);
			
			pwr.write(lista[0]);
			for(int i=1;i<lista.length;i++){
				pwr.write("\n"+lista[i]);	
			}

			pwr.close();
			bw.close();

		} catch (IOException e) {
			System.out.println("Error tratando de escribir");
		}

	}

	public static void main(String[] args) {
		Reader lector = new Reader();
		try {
			lector.leerArchivo("test_file.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
