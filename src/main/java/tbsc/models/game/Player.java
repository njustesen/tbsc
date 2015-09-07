package tbsc.models.game;

import org.mongodb.morphia.annotations.Reference;

import tbsc.models.User;

public class Player {

	@Reference
	User user;
	//AI ai;
	Race race;
	int minerals;
	int gas;
	
}
