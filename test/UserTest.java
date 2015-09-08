import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import tbsc.server.db.DB;
import tbsc.server.db.service.SessionService;
import tbsc.server.db.service.UserService;
import tbsc.shared.model.User;

public class UserTest {
	
	@Before
    public void setUp() {
        DB.connect();
    }

	@Test
	public void testCreate() {
		
		Date date = new Date();
		String username = "jens-" + date.toString();
		String password = "12345678";
		
		User user = UserService.createUser(username, password);
		String session = user.session;
		
		org.junit.Assert.assertTrue("User creation failed", !session.contains("@"));
		
	}
	
	@Test
	public void testCreateAndLogin() {
		
		Date date = new Date();
		String username = "jens-" + date.toString();
		String password = "12345678";
		
		String session = UserService.createUser(username, password).session;
		
		org.junit.Assert.assertTrue("User creation failed", !session.contains("@"));
		
		session = SessionService.createSession(username, "wrongpassword");
		
		org.junit.Assert.assertTrue("User login suceeded with wrong password. Response: " + session, session.contains("@"));
		
		session = SessionService.createSession(username, password);
		
		org.junit.Assert.assertTrue("User login failed with correct password: Response: " + session, !session.contains("@"));
		
	}
	
	@Test
	public void testLogin() {
		
		String session = SessionService.createSession("niller", "12345678");
		
		org.junit.Assert.assertTrue("User login suceeded with wrong password. Response: " + session, !session.contains("@"));
		
		boolean verified = SessionService.verifySession("niller", session);
		
		org.junit.Assert.assertTrue("User session not verifired. Response: " + session, verified);
		
	}
	
}
