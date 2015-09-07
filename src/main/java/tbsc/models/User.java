package tbsc.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class User {
	
	@Id
	public ObjectId id;
	
	public String username;
	public String password;
	public String email;
	
	public String session;
	

}
