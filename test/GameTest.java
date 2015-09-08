import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import tbsc.db.DB;
import tbsc.db.service.GameService;
import tbsc.db.service.ServiceMessage;
import tbsc.db.service.UserService;
import tbsc.models.Game;
import tbsc.models.game.GameStatus;
import tbsc.models.game.Race;

public class GameTest {
	
	private String username;
	private String session;
	private String other;
	private String sessionOther;
	
	@Before
    public void setUp() {
        DB.connect();
        Date date = new Date();
		username = "jens-" + date.toString();
		other = "other-" + date.toString();
		String password = "12345678";
		session = UserService.createUser(username, password).session;
		sessionOther = UserService.createUser(other, password).session;
		
    }

	@Test
	public void testCreate() {
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss);
		
		Assert.assertTrue("Game is null", obj != null);
		Assert.assertTrue("Game is not Game instance", obj instanceof Game);
		
		if (obj instanceof ServiceMessage)
			System.out.println(((ServiceMessage)obj).message);;
		
	}
	
	@Test
	public void testGet() {
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss);
		
		Assert.assertTrue("Game is null", obj != null);
		Assert.assertTrue("Game is not Game instance", obj instanceof Game);
		
		if (obj instanceof ServiceMessage)
			System.out.println(((ServiceMessage)obj).message);;
			
		Game game = (Game)obj;	
		
		Game got = GameService.getGameById(username, session, game.id);
		Assert.assertTrue(got.id.equals(game.id));	
		
		
	}

	@Test
	public void testAccept() {
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss);
		
		Assert.assertTrue("Game is null", obj != null);
		Assert.assertTrue("Game is not Game instance", obj instanceof Game);
		
		if (obj instanceof ServiceMessage)
			System.out.println(((ServiceMessage)obj).message);;
			
		Game game = (Game)obj;	
		
		GameService.acceptGame(other, sessionOther, game.id.toString(), Race.Terran);

		Game got = GameService.getGameById(username, session, game.id);
		Assert.assertTrue(got.status == GameStatus.STARTED);	
		Assert.assertTrue(got.getPlayer(other).race == Race.Terran);
		
	}
	
	@Test
	public void testDecline() {
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss);
		
		Assert.assertTrue("Game is null", obj != null);
		Assert.assertTrue("Game is not Game instance", obj instanceof Game);
		
		if (obj instanceof ServiceMessage)
			System.out.println(((ServiceMessage)obj).message);;
			
		Game game = (Game)obj;	
		
		GameService.declineGame(other, sessionOther, game.id.toString());

		Game got = GameService.getGameById(username, session, game.id);
		Assert.assertTrue(got.status == GameStatus.DECLINED);
		
	}
	
	
}
