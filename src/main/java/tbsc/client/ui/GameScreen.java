package tbsc.client.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

import tbsc.shared.model.Game;

public class GameScreen extends JComponent {

	private Dimension size;
	private Game game;
	
	public GameScreen(Dimension size, Game game){
		GameInputController inputController = new GameInputController(this);
		this.addMouseListener(inputController);
		this.addMouseMotionListener(inputController);
		this.size = size;
		this.game = game;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Image bg = TileSetLib.get(game.map.tileSet).bg;
		g.drawImage(bg, 0, 0, null);
		
	}
	
}
