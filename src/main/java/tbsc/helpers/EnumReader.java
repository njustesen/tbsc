package tbsc.helpers;

public class EnumReader {

	/** 
	 * Finds the value of the given enumeration by name, case-insensitive. 
	 * Throws an IllegalArgumentException if no match is found.  
	 **/
	public static <T extends Enum<T>> T parse(String name, Class<T> enumeration) {

	    for (T enumValue : enumeration.getEnumConstants()) {
	        if (enumValue.name().equalsIgnoreCase(name)) {
	            return enumValue;
	        }
	    }

	    throw new IllegalArgumentException(String.format(
	        "There is no value with name '%s' in Enum %s",
	        name, enumeration.getName()
	    ));
	}
	
}
