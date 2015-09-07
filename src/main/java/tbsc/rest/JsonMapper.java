package tbsc.rest;

import com.google.gson.Gson;

public class JsonMapper {

	private static Gson gson = new Gson();
	
	public static String toJson(Object object){
		return gson.toJson(object);
	}
	
}
