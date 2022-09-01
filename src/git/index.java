package git;
import java.util.*;
import java.io.*;


public class Index {
	
	private File indexFile;
	
	
	public Index() {
		
	}
	
	//makes an object folder, index file 
	public void init() throws IOException {
		File f = new File("Test/Objects");
		f.mkdir();
		indexFile = new File("Test/index.txt");
		FileWriter writer = new FileWriter(indexFile);
	}
	
	public void add(String fileName) throws IOException {//add blob to objects folder, do the index with the fileName : hashedContents
		Blob b = new Blob("Test/" + fileName);//filename ex = foo.txt
//		File f = new File("Test/index.txt");
		Scanner scanner = new Scanner(indexFile);
		String str = "";
		while (scanner.hasNextLine()) {
			str+=scanner.nextLine();
		}
		FileWriter fw = new FileWriter(indexFile);
		fw.append(str + "\n" + fileName + " : " + b.getSha1(fileName));
		fw.close();
	}
	
	public void remove(String fileName) {
		
	}
}
