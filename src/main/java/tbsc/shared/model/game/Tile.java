package tbsc.shared.model.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Tile {
	
	@Id
	ObjectId id;

	@Embedded
	public Map<Direction, TileSide> sides;
	
	@Embedded
	public ResourceField resField;
	
	public int level;
	
	@Embedded 
	public int startingLocation;
	
	@Embedded
	public List<Unit> units;
	
	@Embedded
	public List<Building> buildings;
	
	@Embedded
	public Position pos;
	
	public Tile(){
		
	}
	
	public Tile(Position pos, Map<Direction, TileSide> sides, int level) {
		super();
		this.sides = new HashMap<Direction, TileSide>();
		this.level = level;
		this.units = new ArrayList<Unit>();
		this.buildings = new ArrayList<Building>();
		this.pos = pos;
	}

	public static Map<Direction, TileSide> sides(String code) {
		Map<Direction, TileSide> map = new HashMap<Direction, TileSide>();
		map.put(Direction.UP, decode(code.charAt(0)));
		map.put(Direction.RIGHT, decode(code.charAt(1)));
		map.put(Direction.DOWN, decode(code.charAt(2)));
		map.put(Direction.LEFT, decode(code.charAt(3)));
		return map;
	}

	private static TileSide decode(char c) {
		switch(c){
			case 'F' : return TileSide.FREE;
			case 'W' : return TileSide.WALL;
			case 'P' : return TileSide.PASSAGE;
		}
		return TileSide.WALL;
	}
	
}
