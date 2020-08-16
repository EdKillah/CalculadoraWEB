package edu.escuelaing.arep.sparkweb;

import static spark.Spark.*;

import edu.escuelaing.arep.linkedlistcalculator.calculator.Reader;
import spark.Request;
import spark.Response;

public class SparkWebApp {

	public static void main(String[] args) {
		port(getPort());
		get("/hello", (req, res) -> "Hello Heroku, you are working");
		get("/index", (req, res) -> inputDataPage(req, res));
		get("/results", (req, res) -> resultsPage(req, res));
	}

	static int getPort() {
		System.out.println("Entrando en los puertos");
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set

	}

	private static String inputDataPage(Request req, Response res) {
		String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" + "<h2>HTML Forms</h2>"
				+ "<form action=\"/results\">" + "  Operación:<br>"
				+ "  <input type=\"text\" name=\"firstname\" placeholder=\"Mickey\">" + "  <br>" + "  Lista (Seperada por '-' ) :<br>"
				+ "  <input type=\"text\" name=\"lastname\" placeholder=\"1-2-3\">" + "  <br><br>"
				+ "  <input type=\"submit\" value=\"Submit\">" + "</form>"
				+ "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
				+ "</body>" + "</html>";
		return pageContent;
	}

	private static String resultsPage(Request req, Response res) {
		System.out.println("operacion: "+req.queryParams("firstname"));
		String lista = req.queryParams("lastname");
		System.out.println("Lista: "+lista);
		//Aca podemos crear un metodo intermedio que me convierta el string a una lista o algo así
		String[] numeros = lista.split("-");

		Reader preparer = new Reader();
		String response = preparer.prepareDataToReturn(numeros);
		return req.queryParams("firstname") + " " + req.queryParams("lastname") + " Respuesta: \n"+response;
	}
}