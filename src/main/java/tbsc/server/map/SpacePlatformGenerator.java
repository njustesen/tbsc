package tbsc.server.map;

import java.util.ArrayList;
import java.util.Map;

import tbsc.shared.model.game.Direction;
import tbsc.shared.model.game.Tile;
import tbsc.shared.model.game.TileSide;
import tbsc.shared.model.game.Position;
import tbsc.shared.model.game.ResourceField;
import tbsc.shared.model.game.SCMap;
import tbsc.shared.model.game.Tile;
import tbsc.shared.model.game.TileSet;

public class SpacePlatformGenerator extends MapGenerator {

	@Override
	public SCMap generate() {
	
		SCMap map = new SCMap();
		
		map.name = "Space Platform";
		map.tileSet = TileSet.SPACE_PLATFORM;
		map.version = 1;
		map.tiles = new ArrayList<Tile>();
		
		Map<Direction, TileSide> sidesA = Tile.sides("PWWW");
		Tile hexA = new Tile(new Position(0, 1), sidesA, 0);
		hexA.resField = new ResourceField(Direction.DOWN);
		map.tiles.add(hexA);
		
		Map<Direction, TileSide> sidesAe = Tile.sides("WFPW");
		Tile hexAe = new Tile(new Position(0, 0), sidesAe, 0);
		hexAe.resField = new ResourceField(Direction.LEFT);
		map.tiles.add(hexAe);
		
		Map<Direction, TileSide> sidesB = Tile.sides("PWWW");
		Tile hexB = new Tile(new Position(1, 1), sidesB, 0);
		hexB.resField = new ResourceField(Direction.DOWN);
		map.tiles.add(hexB);
		
		Map<Direction, TileSide> sidesBe = Tile.sides("WWPF");
		Tile hexBe = new Tile(new Position(1, 1), sidesBe, 0);
		hexBe.resField = new ResourceField(Direction.RIGHT);
		map.tiles.add(hexBe);
		
		return map;
		
	}

	
	
}
