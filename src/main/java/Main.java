import tbsc.db.DB;
import tbsc.rest.RestApp;

public class Main {

	public static void main(String[] args) {

		DB.connect();
		
		new RestApp();
		
	}

}
