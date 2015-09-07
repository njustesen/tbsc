package tbsc.rest;

import static spark.Spark.post;

import tbsc.db.service.UserService;

public class UserController implements Controller {

	@Override
	public void addActions() {
		
		post("/user/create", (req, res) -> JsonMapper.toJson(
			UserService.createUser(
			    req.queryParams("username"),
			    req.queryParams("email")
			)
		));
		
	}
	
}
