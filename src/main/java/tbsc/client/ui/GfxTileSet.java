package tbsc.client.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tbsc.shared.model.game.TileSet;
import tbsc.shared.util.PathHelper;

public class GfxTileSet {

	public TileSet tileSet;
	public BufferedImage bg;
	
	public GfxTileSet(TileSet tileSet) {
		super();
		this.tileSet = tileSet;
	}

	public static GfxTileSet generate(TileSet tileSet) throws IOException {
		String basePath = PathHelper.basePath();
		System.out.println("BasePath = " + basePath);
		GfxTileSet set = new GfxTileSet(tileSet);
		set.bg = ImageIO.read(new File(basePath + "/img/game/tilesets/" + set.urlName() + "/bg.jpg"));
		return set;
	}

	private String urlName() {
		return tileSet.name().toLowerCase().replace('_', '-');
	}
	
}
