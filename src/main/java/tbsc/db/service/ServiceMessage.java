package tbsc.db.service;

public class ServiceMessage {

	String message;
	boolean error;
	
	public ServiceMessage(boolean error, String message) {
		super();
		this.message = message;
		this.error = error;
	}
	
}
