package tbsc.client.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JComponent;

import tbsc.shared.model.Game;

public class GameScreen extends JComponent {

	private Dimension size;
	private Game game;
	private Point camera;
	
	public GameScreen(Dimension size, Game game){
		GameInputController inputController = new GameInputController(this);
		this.addMouseListener(inputController);
		this.addMouseMotionListener(inputController);
		this.size = size;
		this.game = game;
		this.camera = new Point(0,0);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Image bg = TileSetLib.get(game.map.tileSet).bg;
		int y = 0;
		while(y <= size.height){
			int x = 0;
			while(x <= size.width){
				g.drawImage(bg, x, y, null);
				x += bg.getWidth(null);
			}
			y += bg.getHeight(null);
		}
		
	}
	
}
