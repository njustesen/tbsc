package tbsc.client;

import tbsc.client.ui.GameScreen;
import tbsc.client.ui.UI;
import tbsc.shared.model.Game;

public class Client {

	public static void main(String[] args) {
		
		ServerConnection con = new ServerConnection("https://tbsc-dev.herokuapp.com");
		
		Session session = con.createSession("niller", "12345678");
		
		Game game = con.getGameById("55eed69aa641ed43120c51f7", session);
		
		UI ui = new UI();
		ui.showGame(game);
		
	}

}
