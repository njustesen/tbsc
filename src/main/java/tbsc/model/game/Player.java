package tbsc.model.game;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

import tbsc.model.User;

@Embedded
public class Player {

	@Reference
	public User user;
	//AI ai;
	public Race race;
	public int minerals;
	public int gas;
	
	public Player(){
		
	}
	
	public Player(User user, Race race) {
		super();
		this.user = user;
		this.race = race;
		this.minerals = 50;
		this.gas = 0;
	}
	
}
