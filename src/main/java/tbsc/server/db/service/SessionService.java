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
			if (query.countAll() == 0){
				System.out.println("No user found.");
				return null;
			}	
			User user = query.get();
			user.session = new RandomStringGenerator().generate();
			DB.datastore.save(user);
			System.out.println("Session set to " + user.session);
			return user.session;
		} catch (Exception e){
			System.out.println("Exception: " + e);
			return null;
		}
		
	}
	
	public static boolean verifySession(String username, String session) {
		
		try {
			System.out.println("verify session called");
			System.out.println("username:" + username);
			System.out.println("session:" + session);
			Query<User> query = DB.datastore.createQuery(User.class)
					.field("username").equal(username);
			if (query.countAll() == 0){
				System.out.println("User not found");
				return false;
			}
			User user = query.get();
			if (user.session.equals(session)){
				System.out.println("Session confirmed");
				return true;
			}
			System.out.println("Session NOT confirmed");
			System.out.println("user session: " + user.session);
			System.out.println("user username: " + user.username);
			return false;
		} catch (Exception e){
			System.out.println("Error: " + e);
			return false;
		}
		
	}
	
}
