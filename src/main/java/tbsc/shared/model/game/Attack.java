package tbsc.shared.model.game;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Attack {
	
	boolean air;
	boolean ground;

	int cooldown;
	int attackMod;
	int damage;
	int range;
	
	DamageType type;
	
}
