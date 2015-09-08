package tbsc.server.main;
import tbsc.server.db.DB;
import tbsc.server.rest.RestApp;

public class Main {

	public static void main(String[] args) {
		
		DB.connect();
		
		new RestApp();
		
	}

}
