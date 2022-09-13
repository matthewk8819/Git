import static org.junit.jupiter.api.Assertions.*;

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

class JUnitBlob {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FileUtil.writeStringToFile("test.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		FileUtil.deleteStringToFile("test.txt");
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException {
		Blob bnew = new Blob ("test.txt"); 
		String sha1 = bnew.getSha1("test.txt");
		assertTrue(sha1.equals("adc83b19e793491b1c6ea0fd8b46cd9f32e592fc"));
	}
	
	
	

	
	

}
