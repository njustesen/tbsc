package tbsc.db;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DB {
	
	public static Datastore datastore;
	
	private static String db = "heroku_hvx51c4l";
	private static String username = "njustesen";
	private static String password = "8e483a05bd";
	
	public static void connect(){
		
		final Morphia morphia = new Morphia();
		morphia.mapPackage("tbsc.game");

		MongoClientURI uri = new MongoClientURI("mongodb://" + username + ":" + password + "@ds041603.mongolab.com:41603/heroku_hvx51c4l");
		final MongoClient client = new MongoClient(uri);
		
		datastore = morphia.createDatastore(client, db);
		datastore.ensureIndexes();
		
	}
	
}
