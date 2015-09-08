package tbsc.model.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class UpgradeClass {

	String name;
	Race race;
	
	@Embedded
	List<UpgradeClass> requiredUpgrades;
	
}
