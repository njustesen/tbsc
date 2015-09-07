package tbsc.models.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

public class SCMap {
	
	String name;
	int version;
	TileSet tileSet;
	
	@Embedded
	List<Sector> sectors;
	
	
}
