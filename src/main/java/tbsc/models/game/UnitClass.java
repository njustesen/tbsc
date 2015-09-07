package tbsc.models.game;

import java.util.List;

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
