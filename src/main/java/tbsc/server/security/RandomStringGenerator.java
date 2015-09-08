package tbsc.server.security;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomStringGenerator {
	
	private static SecureRandom random;
	private static final int RADIX = 32;
	
	public RandomStringGenerator(){
		random = new SecureRandom();
	}
	
	public String generate(){
		return new BigInteger(130, random).toString(RADIX);
	}
	
}
