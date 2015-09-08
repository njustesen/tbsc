package tbsc.server.db.service;

public abstract class BaseService {

	protected SessionService sessionService;
	protected UserService userService;
	protected GameService gameService;

	public BaseService(){
		this.sessionService = new SessionService();
		this.userService = new UserService();
		this.gameService = new GameService();
	}
	
}
