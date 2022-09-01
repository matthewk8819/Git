package git;
import java.security.*;
import java.math.*;
import java.util.*;


public class Blob {
	
	public static void main (String [] args) {
		System.out.println(getSha1("hello"));
	}
	
	public static String getSha1 (String input) {
		String value = input;
		String sha1 = "";
		
		// With the java libraries
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(value.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}

		return sha1;
	}
}
