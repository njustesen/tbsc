package tbsc.client;

import tbsc.client.ui.UI;
import tbsc.shared.model.Game;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("Client running ------------------");
		
		ServerConnection con = new ServerConnection("https://tbsc-dev.herokuapp.com");
		
		Session session = con.createSession("niller", "12345678");
		
		Game game = con.getGameById("55eef615a641ed43adabed35", session);
		
		UI ui = new UI();
		ui.showGame(game);
		
	}

}
