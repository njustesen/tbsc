package tbsc.rest.controller;

import static spark.Spark.post;
import tbsc.db.service.UserService;
import tbsc.rest.JsonMapper;

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
