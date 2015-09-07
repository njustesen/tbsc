package tbsc.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import tbsc.models.game.GameStatus;
import tbsc.models.game.Player;
import tbsc.models.game.SCMap;

@Entity("games")
public class Game {
	
	@Id 
	ObjectId id;
	
	@Embedded 
	List<Player> players;
	
	@Embedded
	Player winner;
	
	@Embedded
	SCMap map;
	
	GameStatus status;
	int turn;
	int round;
	
	public Game() {
		super();
		this.turn = 0;
		this.round = 1;
	}
	
}

