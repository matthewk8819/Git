package git;
import java.util.*;
import java.io.*;


public class Index {
	
	private File indexFile;
	private HashMap<String,String> indexMap = new HashMap<String,String>(); //map of the name(txt) and the sha1 of the contents 
	
	
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
//		Scanner txtScanner = new Scanner(fileName);
//		String str = "";
//		while (txtScanner.hasNextLine()) {
//			str+=txtScanner.nextLine();
//		}
//		String sha = Blob.getSha1(str);
		String sha = b.getHashed();
		indexMap.put(fileName, sha);
		Scanner s = new Scanner(indexFile);
		String alreadyIndexed = "";
		while (s.hasNextLine()) {
			alreadyIndexed+=s.nextLine();
		}
		FileWriter fw = new FileWriter(indexFile);
		fw.append(alreadyIndexed + "\n" + fileName + " : " + sha);
		
		fw.close();
	}
	
	public void remove(String fileName) {
		String wo = Blob.getSha1(fileName);
		File f = new File("Test/Objects/" + wo + ".txt");
		f.delete();
	}
	
	
	
}
