package tbsc.db.service;

import tbsc.db.DB;
import tbsc.models.User;

public class UserService {

	public static ServiceMessage createUser(String username, String password) {
		
		User user = new User();
		user.username = username;
		user.password = password;
		user.email = "";
		user.session = "";
		
		try {
			DB.datastore.save(user);
		} catch (Exception e){
			return new ServiceMessage(true, "Unable to create user");
		}
		
		return new ServiceMessage(false, "User was saved");
		
	}

	
	
}
