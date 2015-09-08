package tbsc.server.rest.controller;

import static spark.Spark.post;

import org.bson.types.ObjectId;

import tbsc.server.db.service.GameService;
import tbsc.shared.model.game.Race;
import tbsc.shared.util.EnumReader;
import tbsc.shared.util.JsonMapper;

public class GameController implements Controller {
	
	@Override
	public void addActions() {
		
		post("/game/create", (req, res) -> JsonMapper.toJson(
			GameService.createGame(
			    req.queryParams("username"),
			    req.queryParams("session"),
			    req.queryParams("other"),
			    EnumReader.parse(req.queryParams("race"), Race.class),
			    req.queryParams("map")
			)
		));
		
		post("/game/byuser/", (req, res) -> JsonMapper.toJson(
			GameService.getGamesByUsername(
			    req.queryParams("username"),
			    req.queryParams("session")
			)
		));
		
		post("/game/byid/", (req, res) -> JsonMapper.toJson(
				GameService.getGameById(
				    req.queryParams("username"),
				    req.queryParams("session"),
				    new ObjectId(req.queryParams("id"))
				)
			));
		
		post("/game/accept/", (req, res) -> JsonMapper.toJson(
			GameService.acceptGame(
			    req.queryParams("username"),
			    req.queryParams("session"),
			    req.queryParams("id"),
			    EnumReader.parse(req.queryParams("race"), Race.class)
			)
		));
		
		post("/game/decline/", (req, res) -> JsonMapper.toJson(
			GameService.declineGame(
			    req.queryParams("username"),
			    req.queryParams("session"),
			    req.queryParams("id")
			)
		));
		
	}
	
}
