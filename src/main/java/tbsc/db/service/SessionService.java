package tbsc.db.service;

import org.mongodb.morphia.query.Query;

import tbsc.db.DB;
import tbsc.models.User;
import tbsc.security.PasswordHasher;
import tbsc.security.RandomStringGenerator;

public class SessionService {

	public Object createSession(String username, String password) {
		
		try {
			String md = new PasswordHasher().hash(password);
			Query<User> query = DB.datastore.createQuery(User.class)
					.field("username").equal(username)
					.field("password").equal(md);
			if (query.countAll() == 0)
				return new ServiceMessage(true, "Wrong username or password");
			User user = query.get();
			user.session = new RandomStringGenerator().generate();
			DB.datastore.save(user);
			return user.session;
		} catch (Exception e){
			return new ServiceMessage(true, "Server error");
		}
		
	}
	
	public Object verifySession(String username, String session) {
		
		try {
			Query<User> query = DB.datastore.createQuery(User.class)
					.field("username").equal(username);
			if (query.countAll() == 0)
				return new ServiceMessage(true, "Unknown username");
			User user = query.get();
			if (user.session.equals(session))
				return true;
			return false;
		} catch (Exception e){
			return new ServiceMessage(true, "Server error");
		}
		
	}

	
	
}
