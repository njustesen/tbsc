package tbsc.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("users")
public class User {
	
	@Id
	public ObjectId id;
	
	public String username;
	public String password;
	public String email;
	
	public String session;
	

}
