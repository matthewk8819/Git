import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		return sha1(str);
		
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
	
	public void writingToFile (ArrayList <String> arr, String str) throws IOException {
		
		FileWriter fw = new FileWriter(new File("objects", str + ".txt"));
		for(String stringe: arr) {
		  fw.write(str + System.lineSeparator());
		}
		fw.close();
		
	}
}
