package git;
import java.util.*;
import java.io.*;


public class Index {
	
	
	
	public Index() {
		
	}
	
	//makes an object folder, index file 
	public void init() throws IOException {
		File f = new File("Test/Objects");
		f.mkdir();
		File f1 = new File("Test/index.txt");
		FileWriter writer = new FileWriter(f1);
	}
	
	public void add(String fileName) throws IOException {//add blob to objects folder, do the index with the fileName : hashedContents
		Blob b = new Blob("Test/" + fileName);//filename ex = foo.txt
		
	}
	
	public void remove(String fileName) {
		
	}
}
