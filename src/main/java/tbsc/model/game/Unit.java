package tbsc.model.game;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class Unit {
	
	@Reference
	UnitClass unitClass;
	
	Race race;
	int hp;
	int energy;
	int shield;
	
	@Embedded
	Player owner;

}
