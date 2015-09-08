package tbsc.rest.controller;

import static spark.Spark.post;
import tbsc.db.service.SessionService;
import tbsc.rest.JsonMapper;

public class SessionController implements Controller {

	@Override
	public void addActions() {
		
		post("/session/create", (req, res) -> JsonMapper.toJson(
			SessionService.createSession(
			    req.queryParams("username"),
			    req.queryParams("password")
			)
		));
		
	}
	
}
