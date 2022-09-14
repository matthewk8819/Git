import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import git.Blob;
import git.index;

class JUnitBlob {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FileUtil.writeStringToFile("naalah.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		FileUtil.deleteStringToFile("naalah.txt");
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testingFileContents() throws IOException {
		Blob bnew = new Blob ("naalah.txt");
		String sha1 = bnew.getSha1("hi poopie pants ");
		System.out.println(sha1); 
		assertTrue(sha1.equalsIgnoreCase("8CB1F7AD8A6EA433BC04A3B374813448448D8740"));
	}
	
	@Test
	void testingFileLocationandName () throws IOException{
		Blob bnew = new Blob ("naalah.txt");
		Path p = Paths.get("8CB1F7AD8A6EA433BC04A3B374813448448D874");
		assertTrue(Files.exists(p));
//		String sha1 = bnew.getSha1("naalah.txt");
//		Path
//		FileUtil,writeStringToFile("")
//		String path = file.absolutePath (); 
//		String fileName = path + "8CB1F7AD8A6EA433BC04A3B374813448448D874";
//		
//		assertTrue(file.exists("fileName"))
		
	} 
//	
////
//	@Test 
//	void testingifInObjectsFolderandIfExists () throws IOException{
//		Blob blobbie = new Blob ("test.txt");
//		
//		File f = new File("./objects/adc83b19e793491b1c6ea0fd8b46cd9f32e592fc");
//		assertTrue(f.exists()); 
//	}
//	
//	@Test
//	void testingIfObjectsDirectoryExists() throws IOException {
//		Blob blobbie = new Blob ("test.txt");
//
//		File file = new File ("index"); 
//		assertTrue(file.exists()); 
//		
//		
//		Path p = Paths.get("objects");
//		assertTrue(Files.exists(p));
//	}
//	
//	@Test 
//	void testingIfIndexExists() throws IOException {
//		index indexie = new index (); 
//		indexie.init(); 
//		assertTrue();
//	}
//	
//	File getFile () {
//		return 
//	}
//	
//	
//	@Test
//	void testingifIndexIsCorrectAfter () throws IOException {
//		index indexie = new index (); 
//		indexie.init(); 
//		FileUtil.writeStringToFile("Test/index.txt");
//		
//		Blob blobbie = new Blob ("naalah.txt"); 
//		
//	}
//	
//	
	
	

	
	

}
