package edu.escuelaing.arep.linkedlistcalculator.calculator;

import edu.escuelaing.arep.linkedlistcalculator.linkedlist.LinkedList;

/**
 * Contains methods for calculate mean and standar deviation usgin a Linked List.
 * @author Eduard Jimenez
 *
 */
public class Calculator {

	/**
	 * Calculates the list mean passed by parameter 
	 * @param lista
	 * @return mean.
	 */
	public Double calculateMean(LinkedList lista) {
		int size = lista.size();
		if (size <= 0) {
			return 0.0;
		}
		double suma = 0;
		for (int i = 0; i < size; i++) {
			suma += lista.get(i).getData();
		}
		return (double) Math.round((suma / size) * 100) / 100;

	}

	/**
	 * Calculates the list standar deviation passed by parameter 
	 * @param lista
	 * @return Double standar deviation.
	 */
	public Double calculateStandarDeviation(LinkedList lista) {
		int size = lista.size();
		if (size < 2) {
			return 0.0;
		} else {
			double value = 0.0;
			double mean = calculateMean(lista);
			for (int i = 0; i < size; i++) {
				value = value + Math.pow((lista.get(i).getData() - mean), 2);
			}
			double standarDeviation = Math.sqrt(value / (size - 1));
			return (double) Math.round(standarDeviation * 100) / 100;

		}

	}


}
