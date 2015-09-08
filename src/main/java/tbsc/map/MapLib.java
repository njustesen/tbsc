package tbsc.map;

import java.util.ArrayList;
import java.util.List;

import tbsc.model.game.SCMap;

public class MapLib {

	private static List<SCMap> maps;
	static {
		maps = new ArrayList<SCMap>();
		maps.add(new SpacePlatformGenerator().generate());
	}
	
	public static SCMap get(String name){
		return maps.stream()
				.filter(map -> map.name == name)
				.findFirst().get();
	}
	
}
