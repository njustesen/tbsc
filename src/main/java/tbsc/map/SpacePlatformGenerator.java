package tbsc.map;

import java.util.ArrayList;

import tbsc.model.game.Direction;
import tbsc.model.game.Hex;
import tbsc.model.game.Position;
import tbsc.model.game.ResourceField;
import tbsc.model.game.SCMap;
import tbsc.model.game.Sector;
import tbsc.model.game.TileSet;

public class SpacePlatformGenerator extends MapGenerator {

	@Override
	public SCMap generate() {
	
		SCMap map = new SCMap();
		
		map.name = "Space Platform";
		map.tileSet = TileSet.SPACE_PLATFORM;
		map.version = 1;
		map.sectors = new ArrayList<Sector>();
		
		Hex hexA = new Hex(new ResourceField(Direction.N), 1, "WWPWWW");
		map.sectors.add(new Sector(new Position(0, 0), hexA, 0));
		
		Hex hexAne = new Hex(null, 0, "WWWWFP");
		map.sectors.add(new Sector(new Position(1, 1), hexAne));
		
		Hex hexB = new Hex(new ResourceField(Direction.N), 1, "WWWWWP");
		map.sectors.add(new Sector(new Position(1, 2), hexB, 1));
		
		Hex hexBne = new Hex(null, 0, "WFPWWW");
		map.sectors.add(new Sector(new Position(0, 1), hexBne));
		
		return map;
		
	}

	
	
}
