import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Tree {
	public Tree (ArrayList <String> arr) {
		
	}
	
	public String generateAll (ArrayList <String> arr) {
		String str = ""; 
		for(int i =0; i < arr.size(); i++) {
			str += arr.get(i);
		}
		
	}
	
	public String sha1 (String input) {
		String value = input;
		String sha1 = "";
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
