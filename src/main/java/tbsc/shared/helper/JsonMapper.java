package tbsc.shared.helper;

import com.google.gson.Gson;

public class JsonMapper {

	private static Gson gson = new Gson();
	
	public static String toJson(Object object){
		return gson.toJson(object);
	}
	
	public static Object fromJson(String json, Class classOfT){
		return gson.fromJson(json, classOfT);
	}
	
}
