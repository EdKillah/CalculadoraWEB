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

	public static void main(String[] args) {
		staticFiles.location("/public");  //La cosa più importante per caricare i static files
		port(getPort());
        
		get("/hello", (req, res) -> "Hello Heroku, you are working");    
        get("/index", SparkWebApp::inputDataPage,new ThymeleafTemplateEngine());
        get("/results", SparkWebApp::resultsPage, new ThymeleafTemplateEngine());
	}

	static int getPort() {
		System.out.println("Entrando en los puertos");
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set

	}
	

	private static ModelAndView inputDataPage(Request req, Response res) {	
		Map<String, Object> params = new HashMap<>();		
		return new ModelAndView(params,"index");
	}

	public static ModelAndView resultsPage(Request req, Response res) {	
		String lista = req.queryParams("lastname");
		System.out.println("Lista: " + lista);
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