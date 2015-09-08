package tbsc.server.rest;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.ArrayList;
import java.util.List;

import tbsc.server.rest.controller.Controller;
import tbsc.server.rest.controller.TestController;
import tbsc.server.rest.controller.UserController;

public class RestApp {

	private List<Controller> controllers;
	
	public RestApp(){
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");
		get("/test", (req, res) -> "Hello World!");
		controllers = new ArrayList<Controller>();
		addControllers();
		init();
	}

	private void addControllers() {
		controllers.add(new UserController());
		controllers.add(new TestController());
	}
	
	private void init(){
		for(Controller controller : controllers)
			controller.addActions();	
	}
	
}
