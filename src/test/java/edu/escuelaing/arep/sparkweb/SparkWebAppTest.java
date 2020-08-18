package edu.escuelaing.arep.sparkweb;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.escuelaing.arep.linkedlistcalculator.calculator.Calculator;
import edu.escuelaing.arep.linkedlistcalculator.calculator.Reader;
import edu.escuelaing.arep.linkedlistcalculator.linkedlist.LinkedList;

public class SparkWebAppTest {

	@Test
	public void itShouldCalculateMean() throws Exception {
		Calculator calculator = new Calculator();
		LinkedList lista = new LinkedList();
		lista.add(44.2);
		lista.add(4.5);
		lista.add(111.1);
		Double value = calculator.calculateMean(lista);
		assertEquals(53.27, value, 0);

	}

	@Test
	public void itShouldCalculateStandarDeviation() throws Exception {
		Calculator calculator = new Calculator();
		LinkedList lista = new LinkedList();
		lista.add(44.2);
		lista.add(4.5);
		lista.add(111.1);
		Double value = calculator.calculateStandarDeviation(lista);
		assertEquals(53.88, value, 0);
	}

	@Test
	public void itShouldnotCalculateMean() {
		Calculator calculator = new Calculator();
		LinkedList lista = new LinkedList();
		lista.add(55.55);
		lista.add(43.5);
		lista.add(11.1);
		lista.add(32);
		Double value = calculator.calculateMean(lista);
		assertNotEquals(35.99, value, 0);
	}

	@Test
	public void itShouldnotCalculateStandarDeviation() {
		Calculator calculator = new Calculator();
		LinkedList lista = new LinkedList();
		lista.add(44.2);
		lista.add(4.5);
		lista.add(111.1);
		Double value = calculator.calculateStandarDeviation(lista);
		assertNotEquals(35.12, value, 0);
	}

	@Test
	public void itShouldCalculateMeanAndStandarDFromFile() throws Exception {

		Reader lector = new Reader();
		String result = "Mean: " + 550.6 + " Standar deviation: " + 572.03;
		String rute = "src/test/test_files/1.txt";
		String[] value = lector.leerArchivo(rute);
		String rta = value[0] + " " + value[1];

		assertEquals(result, rta);
	}

	@Test
	public void itShouldnotCalculateMeanAndStandarDFromFile() throws Exception {
		Reader lector = new Reader();
		String result = "Mean: " + 540.6 + "Standar deviation: " + 572.07;
		String rute = "src/test/test_files/1.txt";
		String[] value = lector.leerArchivo(rute);
		assertNotEquals(value[0]+value[1], result);
	}

	@Test
	public void itShouldRemoveFromList() {
		LinkedList lista = new LinkedList();
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.remove();
		assertEquals(2, lista.size());
	}

	@Test
	public void itShouldRemoveFromList2() {
		LinkedList lista = new LinkedList();
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.remove();
		assertNotEquals(3, lista.size());
	}

}
