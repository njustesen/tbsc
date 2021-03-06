package tbsc.shared.model.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class UnitClass {
	
	String name;
	List<BuildingClass> requires;
	
	int minerals;
	int gas;
	
	int hp;
	int baseShield;
	int baseArmour;
	int baseDamage;
	UnitSize size;
	Attack airAttack;
	Attack groundAttack;
	
	int speed;
	
	boolean biological;
	boolean mechanical;
	boolean detector;
	boolean worker;
	

}
