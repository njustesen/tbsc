package tbsc.server.main;
import tbsc.server.db.DB;
import tbsc.server.rest.RestApp;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("SERVER RUNNING ---------------");
		
		DB.connect();
		
		new RestApp();
		
	}

}
