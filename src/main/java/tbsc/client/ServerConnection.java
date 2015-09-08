package tbsc.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import tbsc.shared.helper.JsonMapper;
import tbsc.shared.model.Game;

public class ServerConnection {

	private String baseURL;
	
	public ServerConnection(String baseURL) {
		super();
		this.baseURL = baseURL;
	}
	
	public Game getGameById(String id, Session session){
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.post(baseURL + "/game/byid/")
					  .header("accept", "application/json")
					  .field("username", session.username)
					  .field("session", session.key)
					  .field("id", id)
					  .asJson();
			
			String json = jsonResponse.getRawBody().toString();
			
			return (Game) JsonMapper.fromJson(json, Game.class); 
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public Session createSession(String username, String password) {
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.post(baseURL + "/session/create/")
					  .header("accept", "application/json")
					  .field("username", username)
					  .field("password", password)
					  .asJson();
			
			String session = jsonResponse.getRawBody().toString();
			
			return new Session(username, session); 
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
