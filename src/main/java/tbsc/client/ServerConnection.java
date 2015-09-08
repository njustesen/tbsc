package tbsc.client;

import java.io.IOException;

import org.eclipse.jetty.server.Authentication.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import tbsc.shared.model.Game;
import tbsc.shared.util.JsonMapper;

public class ServerConnection {

	private String baseURL;
	
	public ServerConnection(String baseURL) {
		super();
		this.baseURL = baseURL;
		setup();
	}
	
	private void setup() {
		
		Unirest.setObjectMapper(new ObjectMapper() {
		    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
		                = new com.fasterxml.jackson.databind.ObjectMapper();

		    public <T> T readValue(String value, Class<T> valueType) {
		        try {
		            return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
		    }

		    public String writeValue(Object value) {
		        try {
		            return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException(e);
		        }
		    }
		});
		
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
			HttpResponse<User> jsonResponse = Unirest.post(baseURL + "/session/create")
					  .header("accept", "application/json")
					  .field("username", username)
					  .field("password", password)
					  .asObject(User.class);
			
			String session = jsonResponse.getRawBody().toString();
			
			return new Session(username, session); 
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
