package edu.escuelaing.arep.sparkweb;

import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku, you are working");
    }

    static int getPort() {
        System.out.println("Entrando en los puertos");
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set

    }
}