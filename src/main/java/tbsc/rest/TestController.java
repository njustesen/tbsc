package tbsc.rest;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class TestController implements Controller {

	@Override
	public void addActions() {
		
		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");
			return new ModelAndView(attributes, "index.ftl");
		}, new FreeMarkerEngine());
		
		get("/ping", (req, res) -> "Hello World!");
		
	}
	
}
