package tbsc.client.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tbsc.server.map.SpacePlatformGenerator;
import tbsc.shared.model.game.SCMap;
import tbsc.shared.model.game.TileSet;

public class TileSetLib {

	private static List<GfxTileSet> tileSets;
	static {
		tileSets = new ArrayList<GfxTileSet>();
		try {
			tileSets.add(GfxTileSet.generate(TileSet.SPACE_PLATFORM));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static GfxTileSet get(TileSet tileSet){
		return tileSets.stream()
				.filter(map -> map.tileSet == tileSet)
				.findFirst().get();
	}
	
}
