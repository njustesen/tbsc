package tbsc.models.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Sector {

	@Embedded
	HexConfig hex;
	
	@Embedded
	List<Unit> units;
	
	@Embedded
	List<Building> buildings;
	
	int x;
	int y;
	
}
