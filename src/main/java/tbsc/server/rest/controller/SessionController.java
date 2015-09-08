package tbsc.server.rest.controller;

import static spark.Spark.post;
import tbsc.server.db.service.SessionService;
import tbsc.shared.helper.JsonMapper;

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
