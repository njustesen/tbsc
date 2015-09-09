package tbsc.shared.model.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class SCMap {
	
	public String name;
	public int version;
	public TileSet tileSet;
	
	@Embedded
	public List<Tile> tiles;
	
}
