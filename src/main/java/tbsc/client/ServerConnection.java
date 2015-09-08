package tbsc.client;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import tbsc.shared.model.Game;
import tbsc.shared.model.User;
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
			HttpResponse<Game> jsonResponse = Unirest.post(baseURL + "/game/byid/")
					  .header("accept", "application/json")
					  .field("username", session.username)
					  .field("session", session.key)
					  .field("id", id)
					  .asObject(Game.class);
			
			Game game = jsonResponse.getBody();
			
			return game; 
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public Session createSession(String username, String password) {
		
		try {
			HttpResponse<String> jsonResponse = Unirest.post(baseURL + "/session/create")
					  .header("accept", "application/json")
					  .field("username", username)
					  .field("password", password)
					  .asObject(String.class);
			
			String session = strip(jsonResponse.getBody());
			
			return new Session(username, session); 
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	private String strip(String string) {
		if (string.length() > 1 && string.charAt(0) == '"' && string.charAt(string.length()-1) == '"')
			return string.substring(1, string.length()-1);
		return string;
	}
	
}
