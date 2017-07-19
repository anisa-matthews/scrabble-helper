import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class DictionaryTest {

	final String file = "CatDictionaryTester.txt"; 

	//test constructor behavior when called with a File object that does not represent a valid file 	
		@Test
		public void testConstructorInvalid1() {
			try{ 
				Dictionary d = new Dictionary (new File ("madeup_file_name.txt") );
				
				fail("Exception not thrown when constructor called with invalid File object ");
				
			}
			catch (IllegalArgumentException ex ) {
				//correct behavior 
			}
			catch (Exception ex ) {
				fail("Incorrect exception thrown from the constructor.");
			}
			
		}
		
		//test constructor behavior when called with a null reference as parameter 
		@Test
		public void testConstructorInvalid2() {
			try{ 
				Dictionary d = new Dictionary ( null  );
				
				fail("Exception not thrown when constructor called with null parameter ");
				
			}
			catch (IllegalArgumentException ex ) {
				//correct behavior 
			}
			catch (Exception ex ) {
				fail("Incorrect exception thrown from the constructor.");
			}
			
		}
		
		//test constructor behavior when called with a File object representing an existing valid file 
		@Test
		public void testConstructorValid1() {
			try{ 
				Dictionary d = new Dictionary (new File (file) );
				
				assertNotNull( "Reference null after constructor returns.", d );
				
			}
			catch (Exception ex ) {
				fail("Exception thrown by constructor when a valid file is used.");
			}
			
		}
		
		//test isWord with all words in the dictionary 
		@Test
		public void testIsWordValid ( ) {
			Dictionary d = null; 
			try{ 
				d = new Dictionary (new File (file) );

			}
			catch (Exception ex ) {
				fail("Exception thrown by constructor when a valid file is used.");
			}
			
			
			String [] words  = {"act", "acta",  "ats", "cat", "cata", "catta", "catts", "sat", "scatt", "tac"};
			
			
			String w = "";
			try { 
				for (int i = 0; i < words.length; i++) {
					w =  words[i]; 
					assertTrue( "isWord failed to return true with "+ w,  d.isWord(w) );
				}
			}
			catch (Exception e ) {
				fail("Unexpected exception thrown.");
			}
			
			
		}

		
		//test isWord with words that do not exist in the dictionary 
		@Test
		public void testIsWordInvalid ( ) {
			Dictionary d = null; 
			try{ 
				d = new Dictionary (new File (file) );

			}
			catch (Exception ex ) {
				fail("Exception thrown by constructor when a valid file is used.");
			}
			
			
			String [] words  = {"catt", "ac", "at", "atac" ,"zebra" };
			
			
			String w = "";
			try { 
				for (int i = 0; i < words.length; i++) {
					w =  words[i]; 
					assertFalse( "isWord failed to return false with " + w,  d.isWord(w) );
				}
			}
			catch (Exception e ) {
				fail("Unexpected exception thrown.");
			}
			
			
		}
		

		
		//test isPrefix with some prefixes  in the dictionary 
		@Test
		public void testIsPrefixValid ( ) {
			Dictionary d = null; 
			try{ 
				d = new Dictionary (new File (file) );

			}
			catch (Exception ex ) {
				fail("Exception thrown by constructor when a valid file is used.");
			}
			
			
			String [] words  = {"ac", "act", "t", "c", "cat", "sc", "tac"}; 
			
			String w = "";
			try { 
				for (int i = 0; i < words.length; i++) {
					w =  words[i]; 
					assertTrue( "isPrefix failed to return true with "+ w,  d.isPrefix(w) );
				}
			}
			catch (Exception e ) {
				fail("Unexpected exception thrown.");
			}
			
			
		}

		
		//test isPrefix with prefixes that do not exist in the dictionary 
		@Test
		public void testIsPrefixInvalid ( ) {
			Dictionary d = null; 
			try{ 
				d = new Dictionary (new File (file) );

			}
			catch (Exception ex ) {
				fail("Exception thrown by constructor when a valid file is used.");
			}
			
			
			String [] words  = {"ast", "tact", "catas", "ab" ,"z" };
			
			
			String w = "";
			try { 
				for (int i = 0; i < words.length; i++) {
					w =  words[i]; 
					assertFalse( "isWord failed to return false with " + w,  d.isWord(w) );
				}
			}
			catch (Exception e ) {
				fail("Unexpected exception thrown.");
			}
			
			
		}

}
