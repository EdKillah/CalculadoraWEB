package edu.escuelaing.arep.sparkweb;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.linkedlistcalculator.calculator.Reader;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import spark.Request;
import spark.Response;

public class SparkWebApp {

	/**
	 * Main method set staticFils location, recives get petitions from client side
	 * and set a port to work.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		staticFiles.location("/public"); // La cosa più importante per caricare i static files
		port(getPort());
		get("/hello", (req, res) -> "Hello Heroku, you are working");
		get("/index", SparkWebApp::inputDataPage, new ThymeleafTemplateEngine());
		get("/", SparkWebApp::inputDataPage, new ThymeleafTemplateEngine());
		get("/results", SparkWebApp::resultsPage, new ThymeleafTemplateEngine());
	}

	/**
	 * Gets heroku's port if its given one, otherwise returns 4567 by defult.
	 * 
	 * @return
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set

	}

	/**
	 * 
	 * @param req request made from client side
	 * @param res response from server
	 * @return ModelAndView html page with elements to be renderized using thymleaf
	 */
	private static ModelAndView inputDataPage(Request req, Response res) {
		System.out.println("Request inputData: "+req);
		Map<String, Object> params = new HashMap<>();
		return new ModelAndView(params, "index");
	}

	/**
	 * resultsPage returns results page with mean and standar deviation of number
	 * list passed by req
	 * 
	 * @param req request made from client side
	 * @param res response from server
	 * @return ModelAndView html page with elements to be renderized
	 */
	public static ModelAndView resultsPage(Request req, Response res) {
		String lista = req.queryParams("lista");
		Map<String, Object> params = new HashMap<>();
		String[] numeros = lista.split("-");
		Reader preparer = new Reader();
		String[] response = preparer.prepareDataToReturn(numeros);
		params.put("mean", response[0]);
		params.put("standarDeviation", response[1]);
		params.put("list", numeros);		 
		return new ModelAndView(params, "resultado"); 
	}
}