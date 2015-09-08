package tbsc.models.game;

import java.util.Map;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class HexConfig {

	@Embedded
	Map<Direction, HexSide> sides;
	
	@Embedded
	ResourceField resField;
	
	int level;
	
}
