package tbsc.models.game;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Building {

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
