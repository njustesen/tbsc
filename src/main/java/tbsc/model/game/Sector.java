package tbsc.model.game;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Sector {

	@Embedded
	public Hex hex;
	
	@Embedded 
	public int startingLocation;
	
	@Embedded
	public List<Unit> units;
	
	@Embedded
	public List<Building> buildings;
	
	public Position pos;
	
	public Sector(){
		
	}
	
	public Sector(Position pos, Hex hex, int startingLocation) {
		super();
		this.hex = hex;
		this.startingLocation = startingLocation;
		this.units = new ArrayList<Unit>();
		this.buildings = new ArrayList<Building>();
		this.pos = pos;
	}
	
	public Sector(Position pos, Hex hex) {
		super();
		this.hex = hex;
		this.startingLocation = -1;
		this.units = new ArrayList<Unit>();
		this.buildings = new ArrayList<Building>();
		this.pos = pos;
	}
	
}
