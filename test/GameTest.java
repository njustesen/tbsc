import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import tbsc.model.Game;
import tbsc.model.game.GameStatus;
import tbsc.model.game.Race;
import tbsc.server.db.DB;
import tbsc.server.db.service.GameService;
import tbsc.server.db.service.ServiceMessage;
import tbsc.server.db.service.UserService;

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
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss, "Space Platform");
		
		Assert.assertTrue("Game is null", obj != null);
		Assert.assertTrue("Game is not Game instance", obj instanceof Game);
		
		if (obj instanceof ServiceMessage)
			System.out.println(((ServiceMessage)obj).message);;
		
	}
	
	@Test
	public void testGet() {
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss, "Space Platform");
		
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
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss, "Space Platform");
		
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
		
		Object obj = GameService.createGame(username, session, other, Race.Protoss, "Space Platform");
		
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
