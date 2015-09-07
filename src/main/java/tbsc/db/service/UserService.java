package tbsc.db.service;

import tbsc.db.DB;
import tbsc.models.User;
import tbsc.security.PasswordHasher;
import tbsc.security.RandomStringGenerator;

public class UserService {

	public Object createUser(String username, String password) {
		
		String md = new PasswordHasher().hash(password);
		
		User user = new User();
		user.username = username;
		user.password = md;
		user.email = "";
		user.session = new RandomStringGenerator().generate();
		
		try {
			DB.datastore.save(user);
		} catch (Exception e){
			return new ServiceMessage(true, "Unable to create user");
		}
		
		return user.session;
		
	}

	
	
}
