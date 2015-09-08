package tbsc.shared.model.game;

import java.util.HashMap;
import java.util.Map;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Hex {

	@Embedded
	public Map<Direction, HexSide> sides;
	
	@Embedded
	public ResourceField resField;
	
	public int level;
	
	public Hex(){
		
	}

	public Hex(ResourceField resField, int level) {
		super();
		this.sides = new HashMap<Direction, HexSide>();
		this.resField = resField;
		this.level = level;
	}
	
	public Hex(ResourceField resField, int level, String code) {
		super();
		this.sides = new HashMap<Direction, HexSide>();
		setupSides(code);
		this.resField = resField;
		this.level = level;
	}
	
	public void setupSides(String code){
		for(int i = 0; i < code.length(); i++){
			switch(code.charAt(i)){
				case 'F' : sides.put(Direction.values()[i], HexSide.FREE); break;
				case 'W' : sides.put(Direction.values()[i], HexSide.WALL); break;
				case 'P' : sides.put(Direction.values()[i], HexSide.PASSAGE); break;
			}
		}
	}
	
}
