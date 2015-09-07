package tbsc.game;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("games")
public class Game {
	@Id
	ObjectId id;
	
	//List<Player> players;
	int turn;
	int round;
	
	SCMap map;
	GameStatus status;
	Player winner;
	
	public Game() {
		super();
		this.turn = 0;
		this.round = 1;
	}
	
}

