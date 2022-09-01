package git;
import java.security.*;
import java.math.*;
import java.util.*;
import java.io.*;



public class Blob {
	
	private String contents;
	
	private String hashedContents;
	
	public Blob (String file) throws IOException {
		String ret = "";
		try {//takes in file, reads in to contents
		      File myObj = new File(file);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        ret+= myReader.nextLine();
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		contents = ret;//contents = what was read in
		hashedContents = getSha1(contents);//call the hash method on the contents, save it in hashedContents
		createFile();
		System.out.println(ret);
		System.out.println(hashedContents);
	}
	
	private void createFile () throws IOException{//Goal: create file in the objects folder with a certain name of the hashed contents 
		    File myObj = new File("Objects/" + hashedContents + ".txt");
		    
	}
	
	
	public String getSha1 (String input) {
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