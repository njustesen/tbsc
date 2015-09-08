package tbsc.server.db.service;

import org.mongodb.morphia.query.Query;

import tbsc.server.db.DB;
import tbsc.server.security.PasswordHasher;
import tbsc.server.security.RandomStringGenerator;
import tbsc.shared.model.User;

public class SessionService {

	public static String createSession(String username, String password) {
		
		try {
			String md = new PasswordHasher().hash(password);
			Query<User> query = DB.datastore.createQuery(User.class)
					.field("username").equal(username)
					.field("password").equal(md);
			if (query.countAll() == 0)
				return null;
			User user = query.get();
			user.session = new RandomStringGenerator().generate();
			DB.datastore.save(user);
			return user.session;
		} catch (Exception e){
			return null;
		}
		
	}
	
	public static boolean verifySession(String username, String session) {
		
		try {
			Query<User> query = DB.datastore.createQuery(User.class)
					.field("username").equal(username);
			if (query.countAll() == 0)
				return false;
			User user = query.get();
			if (user.session.equals(session))
				return true;
			return false;
		} catch (Exception e){
			return false;
		}
		
	}
	
}
