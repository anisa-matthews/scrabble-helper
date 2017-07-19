import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PermutationsTest {


    final String file = "../../data/dictionary_10.txt"; 

	//test constructor behavior with valid parameter: all lower case letters 
	@Test
	public void testConstructorValid1() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "abc" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
	}

	//test constructor behavior with valid parameter: all upper case letters 
	@Test
	public void testConstructorValid2() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "ABC" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
	}

	//test constructor behavior with valid parameter: mixed case letters 
	@Test
	public void testConstructorValid3() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "AbCd" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
	}
	

	//test constructor behavior with invalid parameter: non-letters only starting with digits
	@Test
	public void testConstructorInvalid1() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "187-;" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (IllegalArgumentException ex ) {
			//correct behavior 
		}
		catch (Exception ex ) {
			fail("Incorrect exception thrown from the constructor.");
		}
	}
	

	//test constructor behavior with invalid parameter: non-letters only starting with symbols
	@Test
	public void testConstructorInvalid2() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "+;-2316=" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (IllegalArgumentException ex ) {
			//correct behavior 
		}
		catch (Exception ex ) {
			fail("Incorrect exception thrown from the constructor.");
		}
	}

	//test constructor behavior with invalid parameter: letters and non-letters
	@Test
	public void testConstructorInvalid3() {
		
		Permutations p = null;
		try{ 
			p = new Permutations ( "ab+sq;2b" );
			assertNotNull( "Reference null after constructor returns.", p );
		}
		catch (IllegalArgumentException ex ) {
			//correct behavior 
		}
		catch (Exception ex ) {
			fail("Incorrect exception thrown from the constructor.");
		}
	}


	
	//test if all the permutations are generated 
	@Test
	public void testGetAllPermutations1() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "abc" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		
		String [] perms  = {"abc", "acb", "bac", "bca", "cab", "cba" };
		
		
		String w = "";
		try { 
			ArrayList<String> generated = p.getAllPermutations(); 
			for (int i = 0; i < perms.length; i++) {
				w =  perms[i]; 
				assertTrue( "missing permutation:  "+ w,  generated.contains( w ) );
			}
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
	}
	
	//test if a proper number of permutations is generated 
	@Test
	public void testGetAllPermutations2() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "abc" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		
		String [] perms  = {"abc", "acb", "bac", "bca", "cab", "cba" };
		
		try { 
			ArrayList<String> generated = p.getAllPermutations(); 
			
			assertTrue("inocrrect number of permutations generated", generated.size() == perms.length ); 
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
	}

	//test if all the words that should be generated are generated 	
	@Test
	public void testGetAllWords1() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "tca" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		

		Dictionary d = null; 
		try{ 
			d = new Dictionary (new File (file) );

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid file is used.");
		}
		
		String [] words  = {"act", "tac", "cat"  };
		
		String w = "";
		try { 
			ArrayList<String> generated = p.getAllWords( d ); 
			for (int i = 0; i < words.length; i++) {
				w =  words[i]; 
				assertTrue( "missing words:  "+ w,  generated.contains( w ) );
			}
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
		
	}

	//test if correct number of words is generated 
	@Test
	public void testGetAllWords2() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "tca" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		

		Dictionary d = null; 
		try{ 
			d = new Dictionary (new File (file) );

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid file is used.");
		}
		
		String [] words  = {"act", "tac", "cat"  };
		
		String w = "";
		try { 
			ArrayList<String> generated = p.getAllWords( d ); 
			assertTrue("inocrrect number of permutations generated", generated.size() == words.length ); 
			
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
		
	}


	//test if generated words are in sorted order 
	@Test
	public void testGetAllWords3() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "tca" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		

		Dictionary d = null; 
		try{ 
			d = new Dictionary (new File (file) );

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid file is used.");
		}
		
		try { 
			ArrayList<String> generated = p.getAllWords( d ); 
			assertTrue("too few permutations generated", generated.size() > 0 ); 
			for (int i = 1; i < generated.size(); i++ ) {
				assertTrue("generated list is not sorted ", generated.get(i-1).compareTo(generated.get(i))< 0 ); 
			}
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
		
	}


	//test if generated words contain duplicates  
	@Test
	public void testGetAllWords4() {

		Permutations p = null; 
		try{ 
			p = new Permutations  ( "atca" ); 

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid argument is used.");
		}
		

		Dictionary d = null; 
		try{ 
			d = new Dictionary (new File (file) );

		}
		catch (Exception ex ) {
			fail("Exception thrown by constructor when a valid file is used.");
		}
				
		try { 
			ArrayList<String> generated = p.getAllWords( d ); 
			assertTrue("too few permutations generated", generated.size() > 0 ); 
			for (int i = 1; i < generated.size(); i++ ) {
				assertTrue("generated list contains duplicates", generated.get(i-1).compareTo(generated.get(i)) != 0 ); 
			}
		}
		catch (Exception e ) {
			fail("Unexpected exception thrown.");
		}
		
	}
}
