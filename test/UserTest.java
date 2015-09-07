import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import tbsc.db.DB;
import tbsc.db.service.SessionService;
import tbsc.db.service.UserService;

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
		
		String session = new UserService().createUser(username, password).toString();
		
		org.junit.Assert.assertTrue("User creation failed", !session.contains("@"));
		
	}
	
	@Test
	public void testCreateAndLogin() {
		
		Date date = new Date();
		String username = "jens-" + date.toString();
		String password = "12345678";
		
		String session = new UserService().createUser(username, password).toString();
		
		org.junit.Assert.assertTrue("User creation failed", !session.contains("@"));
		
		session = new SessionService().createSession(username, "wrongpassword").toString();
		
		org.junit.Assert.assertTrue("User login suceeded with wrong password. Response: " + session, session.contains("@"));
		
		session = new SessionService().createSession(username, password).toString();
		
		org.junit.Assert.assertTrue("User login failed with correct password: Response: " + session, !session.contains("@"));
		
	}
	
}
