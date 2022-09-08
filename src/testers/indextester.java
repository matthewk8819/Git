package testers;

import java.io.IOException;

import git.Index;

public class indextester {
	public static void main (String [] args) throws IOException{
		Index index = new Index ();
		index.init();
		
		index.add("foo.txt");
		index.add("bar.txt");
		index.add("NEW TEXT.txt");
		index.add("foobar.txt");
		
		index.remove("NEW TEXT.txt");
		index.remove("foo.txt");
		
	}
}
