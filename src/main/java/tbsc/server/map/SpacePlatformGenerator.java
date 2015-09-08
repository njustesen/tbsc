package tbsc.server.map;

import java.util.ArrayList;

import tbsc.shared.model.game.Direction;
import tbsc.shared.model.game.Hex;
import tbsc.shared.model.game.Position;
import tbsc.shared.model.game.ResourceField;
import tbsc.shared.model.game.SCMap;
import tbsc.shared.model.game.Sector;
import tbsc.shared.model.game.TileSet;

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
