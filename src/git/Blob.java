package git;
import java.security.*;
import java.math.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



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
		
		//File f = new File("objects/"+ hashedContents + ".txt");
		    try {
		    	Path p = Paths.get("Test/Objects/" + hashedContents + ".txt");
		    	Files.createFile(p);
		    	//System.out.println(f.createNewFile());
		    	
		    	FileWriter myWriter = new FileWriter(hashedContents + ".txt");
		        myWriter.write(contents);
		        myWriter.close();
		        System.out.println("Successfully wrote to the file.");
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
	}
	
	
	
	private String getSha1 (String input) {
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
