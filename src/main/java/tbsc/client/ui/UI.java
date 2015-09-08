package tbsc.client.ui;

import javax.swing.JFrame;

import tbsc.shared.model.Game;

public class UI extends JFrame {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public UI(){
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Turn Based StarCraft");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showGame(Game game) {
		
		this.setVisible(false);
		this.getContentPane().add(new GameScreen(this.size(), game));
		this.setVisible(true);
		
	}
	
}
