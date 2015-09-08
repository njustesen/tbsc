package tbsc.server.map;

import tbsc.shared.model.game.SCMap;

public abstract class MapGenerator {

	public abstract SCMap generate();
	
	public String name;
	
}
