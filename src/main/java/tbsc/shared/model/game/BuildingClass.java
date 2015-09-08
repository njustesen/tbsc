package tbsc.shared.model.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class BuildingClass {

	String name;
	
	@Embedded
	List<BuildingClass> requires;
	
	@Embedded
	List<UpgradeClass> upgrades;
	
	@Embedded
	List<ResearchClass> research;
	
	Race race;
	int hp;
	int energy;
	int width;
	int height;
	boolean biological;
	ArmourType armourType;
	int armour;
	
}
