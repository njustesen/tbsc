package tbsc.db.service;

import tbsc.db.DB;
import tbsc.model.User;
import tbsc.security.PasswordHasher;
import tbsc.security.RandomStringGenerator;

public class UserService {

	public static User createUser(String username, String password) {
		
		String md = new PasswordHasher().hash(password);
		
		User user = new User();
		user.username = username;
		user.password = md;
		user.email = "";
		user.session = new RandomStringGenerator().generate();
		
		try {
			DB.datastore.save(user);
		} catch (Exception e){
			return null;
		}
		
		return user;
		
	}

	public static boolean exists(String username) {
		
		return DB.datastore.createQuery(User.class)
			.field("username").equal(username)
			.countAll() > 0;
		
	}

	public static User getUserByName(String username) {
		
		return DB.datastore.createQuery(User.class)
			.field("username").equal(username).get();
		
	}

	
	
}
