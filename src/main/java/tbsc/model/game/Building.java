package tbsc.model.game;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Building {
	
	@Id
	ObjectId id;

	@Embedded
	BuildingClass buildingClass;
	
	@Embedded
	UnitClass trains;
	
	@Embedded
	UpgradeClass upgrades;
	
	@Embedded
	ResearchClass researches;
	
	int hp;
	int x;
	int y;
	
}
