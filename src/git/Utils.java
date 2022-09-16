package git;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
	public Utils() {
		
	}
	
	 void makeTxtFile(String directory, String name) throws IOException {
		File f = new File (directory + "/" + name);
		FileWriter fw = new FileWriter(f);
		fw.append("");
		fw.close();
	}
	
	String readFile(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		String str = "";
		if (f.exists()) {
		Scanner s = new Scanner(f);
		while (s.hasNext()) {
			str+=s.next();
		}
		}
		return str;
	}
}
