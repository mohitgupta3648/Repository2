package eupchaar.ui.automation.utils;

import java.security.SecureRandom;

public class Helpers {
	
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String ab = "abcdefghijklmnopqrstuvwxyz";
	static final String NUM = "123456789";
	static SecureRandom rnd = new SecureRandom();

	public String getRandomAlphabetString(int len)
	{
		
		String first = getString(1, AB);
		String rest = getString(len-1, ab);
		return first+rest;
	}
	
	public String getRandomNumericString(int len)
	{
	   String CharSet = NUM;
	   return getString(len, CharSet);
	}
	
	private String getString(int len, String CharSet)
	{

	   StringBuilder sb = new StringBuilder(len);
	   for( int i = 0; i < len; i++ ) 
	      sb.append( CharSet.charAt(rnd.nextInt(CharSet.length())));
	   return sb.toString();
	}

}
