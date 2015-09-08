package tbsc.shared.model.game;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class Unit {
	
	@Id
	ObjectId id;
	
	@Reference
	UnitClass unitClass;
	
	Race race;
	int hp;
	int energy;
	int shield;
	
	@Embedded
	Player owner;

}
