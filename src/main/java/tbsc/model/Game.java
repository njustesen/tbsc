package tbsc.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import tbsc.model.game.GameStatus;
import tbsc.model.game.Player;
import tbsc.model.game.SCMap;

@Entity("games")
public class Game {
	
	@Id 
	public ObjectId id;
	
	@Embedded 
	public List<Player> players;
	
	@Reference 
	public List<User> users;
	
	@Embedded
	public Player winner;
	
	@Embedded
	public SCMap map;
	
	public GameStatus status;
	public int turn;
	public int round;
	
	public Game(){
		super();
	}
	
	public Game(Player a, Player b) {
		super();
		this.turn = 0;
		this.round = 0;
		this.players = new ArrayList<Player>();
		this.players.add(a);
		this.players.add(b);
		this.users = new ArrayList<User>();
		this.users.add(a.user);
		this.users.add(b.user);
		this.status = GameStatus.CREATED;
	}

	public Player getPlayer(User user) {
		for(Player player : players)
			if (player.user.username.equals(user.username))
				return player;
		return null;
	}

	public Player getPlayer(String username) {
		for(Player player : players)
			if (player.user.username.equals(username))
				return player;
		return null;
	}
	
}

