import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import tbsc.game.Game;

import com.heroku.sdk.jdbc.DatabaseUrl;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String[] args) {

		final Morphia morphia = new Morphia();
		
		// tell Morphia where to find your classes
		// can be called multiple times with different packages or classes
		morphia.mapPackage("tbsc.game");

		// create the Datastore connecting to the default port on the local host
		String username = "heroku_hvx51c4l";
		String password = "8e483a05bd";

		System.out.println("connecting?");
		
		final MongoClient client = new MongoClient("mongodb://" + username + ":" + password + "@ds041603.mongolab.com:41603/heroku_hvx51c4l");

		System.out.println("connected?");
		
		final Datastore datastore = morphia.createDatastore(client, "morphia_example");
		datastore.ensureIndexes();

		System.out.println("saving?");
		
		final Game game = new Game();
		datastore.save(game);
		
		System.out.println("saved?");	
		
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

		get("/hello", (req, res) -> "Hello World 3");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");

			return new ModelAndView(attributes, "index.ftl");
		}, new FreeMarkerEngine());

		get("/db",
				(req, res) -> {
					Connection connection = null;
					Map<String, Object> attributes = new HashMap<>();
					try {
						connection = DatabaseUrl.extract().getConnection();

						Statement stmt = connection.createStatement();
						stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
						stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
						ResultSet rs = stmt
								.executeQuery("SELECT tick FROM ticks");

						ArrayList<String> output = new ArrayList<String>();
						while (rs.next())
							output.add("Read from DB: "
									+ rs.getTimestamp("tick"));

						attributes.put("results", output);
						return new ModelAndView(attributes, "db.ftl");
					} catch (Exception e) {
						attributes.put("message", "There was an error: " + e);
						return new ModelAndView(attributes, "error.ftl");
					} finally {
						if (connection != null)
							try {
								connection.close();
							} catch (SQLException e) {
							}
					}
				}, new FreeMarkerEngine());

	}

}
