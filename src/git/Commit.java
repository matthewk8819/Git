package git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.time.LocalDate;

public class Commit {
	
	private Commit child;
	private Commit parent;
	
	private String commitName = "";
	
	private String pTree;//turns sha1 -> filepath
	
	
	private String summary;
	private String author;
	private String date;//Ex. September 13, 2022
	
	public Commit() {
		
	}
	
	//String tree = tree name, should be sha1 or name of the file
	public Commit(String tree, String sum, String auth, String par) {
		this.commitName = getSha1(pTree,summary);
		this.summary = sum;
		this.author = auth;
		File f = new File (tree);//might need to add Test/Objects/ before
		this.pTree = f.getPath();
		this.date = "" + java.time.LocalDate.now();
		
		this.child = new Commit();
	}
	
	private void writeToFile() throws IOException {
		File f = new File("Test/Objects/" + commitName);
		FileWriter writer = new FileWriter(f);
		writer.append(commitName + "\n");
		writer.append(parent.getCommitName() + "\n");	
		writer.append(child.getCommitName() + "\n");//IDK IF THIS WORKS
		writer.append(author + "\n");
		writer.append(date + "\n");
		writer.append(summary);
		writer.close();
	}
	
	private String getDate() {
		return date;
	}
	
	public String getpTree() {
		return pTree;
	}
	
	public String getCommitName() {
		return this.commitName;
	}
	
	public void setChild (Commit child) {
		this.child = child;
	}
	
	private static String getSha1 (String fileName, String sum) {
		String value = fileName + sum;
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
	
	public String toString() {
		String str = "";
		str += commitName + "\n";
		str += parent.getCommitName() + "\n";
		str += child.getCommitName() + "\n";
		str += author + "\n";
		str += date + "\n";
		str += summary + "\n";
		return str;
	}
	
	public static void main (String [] args) {
		Commit commit = new Commit("Tree.txt","This is a summary","Matthew Ko",null);
		System.out.println(commit.toString());
		
		System.out.println("\n");
		
		//Commit child = new Commit("newTXT.txt","This is the second summary","Steven Ko",commit);
//		commit.setChild(child);
//		System.out.println(child.toString());
	}
	
}
