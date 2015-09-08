package tbsc.server.rest.controller;

import static spark.Spark.post;
import tbsc.server.db.service.UserService;
import tbsc.shared.helper.JsonMapper;

public class UserController implements Controller {
	
	@Override
	public void addActions() {
		
		post("/user/create", (req, res) -> JsonMapper.toJson(
			UserService.createUser(
			    req.queryParams("username"),
			    req.queryParams("password")
			)
		));
		
	}
	
}
