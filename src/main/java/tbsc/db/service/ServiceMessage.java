package tbsc.db.service;

public class ServiceMessage {

	public String message;
	public boolean error;
	
	public ServiceMessage(boolean error, String message) {
		super();
		this.message = message;
		this.error = error;
	}
	
}
