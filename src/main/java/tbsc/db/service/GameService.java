package tbsc.db.service;

import java.util.List;

import org.bson.types.ObjectId;

import tbsc.db.DB;
import tbsc.models.Game;
import tbsc.models.User;
import tbsc.models.game.GameStatus;
import tbsc.models.game.Player;
import tbsc.models.game.Race;

public class GameService {
	
	public static Object createGame(String username, String session, String other, Race race) {
		
		if (other.equals(username))
			return new ServiceMessage(true, "You cannot challenge yourself");
		
		try {
			if (SessionService.verifySession(username, session)){
				if (UserService.exists(other)){
					User userA = UserService.getUserByName(username);
					User userB = UserService.getUserByName(other);
					Game game = new Game(new Player(userA, race), new Player(userB, null));
					DB.datastore.save(game);
					return game;
				} else {
					return new ServiceMessage(true, other + " does not exist");
				}
			} else {
				return new ServiceMessage(true, "You are not logged in");
			}
		} catch (Exception e){
			return new ServiceMessage(true, "Server error");
		}
		
	}
	
	public static List<Game> getGamesByUsername(String username, String session){
		
		try {
			if (SessionService.verifySession(username, session)){
				User user = UserService.getUserByName(username);
				return DB.datastore.createQuery(Game.class)
					.field("users").hasThisElement(user)
					.asList();
			} else {
				return null;
			}
		} catch (Exception e){
			return null;
		}
		
	}
	
	public static Game getGameById(String username, String session, ObjectId id){
		
		try {
			if (SessionService.verifySession(username, session)){
				return DB.datastore.find(Game.class).field("_id").equal(id).get();
			} else {
				return null;
			}
		} catch (Exception e){
			return null;
		}
		
	}

	public static Object acceptGame(String username, String session, String id, Race race) {
		
		try {
			if (SessionService.verifySession(username, session)){
				Game game = getGameById(username, session, new ObjectId(id));
				if (game == null)
					return new ServiceMessage(true, "Game not found");
				User user = UserService.getUserByName(username);
				if (game.getPlayer(user.username) == null)
					return new ServiceMessage(true, "Not authorized");
				if (game.status != GameStatus.CREATED)
					return new ServiceMessage(true, "Game already started");
				
				game.status = GameStatus.STARTED;
				game.getPlayer(user).race = race;
				game.round = 1;
				
				DB.datastore.save(game);
				
				return game;
				
			} else {
				return null;
			}
		} catch (Exception e){
			return null;
		}
		
	}
	
	public static Object declineGame(String username, String session, String id) {
		
		try {
			if (SessionService.verifySession(username, session)){
				Game game = getGameById(username, session, new ObjectId(id));
				if (game == null)
					return new ServiceMessage(true, "Game not found");
				User user = UserService.getUserByName(username);
				if (game.getPlayer(user.username) == null)
					return new ServiceMessage(true, "Not authorized");
				if (game.status != GameStatus.CREATED)
					return new ServiceMessage(true, "Game already started");
				
				game.status = GameStatus.DECLINED;
				DB.datastore.save(game);
				
				return game;
				
			} else {
				return null;
			}
		} catch (Exception e){
			return null;
		}
		
	}
	
	
	
	
}
