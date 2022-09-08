package git;
import java.security.*;
import java.math.*;
import java.util.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Blob {
	
	private String contents;
	
	private String zippedContents;
	
	private String hashedContents;
	
	public String getHashed() {
		return hashedContents;
	}
	
	public Blob (String file) throws IOException {
		String ret = "";
		try {//takes in file, reads in to contents
		      File f = new File(file);
		      Scanner in = new Scanner(f);
		      while (in.hasNextLine()) {
		        ret+= in.nextLine();
		      }
		      in.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		contents = ret;//contents = what was read in
		//HERE WOULD BE: CONTENTS = GETZIP(CONTENTS);
		hashedContents = getSha1(contents);//call the hash method on the contents(now zipped contents), save it in hashedContents
		createFile();
		System.out.println(ret);
		System.out.println(hashedContents);
		System.out.println();
		
		//zip();
	}
	
	private void createFile () throws IOException{//Goal: create file in the objects folder with a certain name of the hashed contents 
		File f = new File("Test/Objects/" + hashedContents + ".txt");//DEPENDENT ON OBJECTS FOLDER NAME = OBJECTS 
		FileWriter writer = new FileWriter(f);
		writer.append(hashedContents);
		writer.close();
	}
	
	private void zip() throws IOException {//zip the existing file that is in the folder
		StringBuilder sb = new StringBuilder();
		sb.append("Test String");

		File f = new File("Test/Objects");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("mytext.txt");
		out.putNextEntry(e);

		byte[] data = sb.toString().getBytes();
		out.write(data, 0, data.length);
		out.closeEntry();

		out.close();
    }
	
	public static String getSha1 (String input) {
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
