import java.io.*;
import java.util.*;


/** Scrabble Helper is responsible for main method and parsing the command line arguments.
*  creates Dictionary and Permutations objects and then uses them to display results.
*  
*  @author Anisa Matthews
*/
public class ScrabbleHelper {
	/** main method
	 * calls other classes, parses command line args.
	 * 
	 * @param args include the dictionary file and the string of letters
	 */
	public static void main(String[] args) {

		File fileName = new File(args[0]);
		Dictionary dictionary = new Dictionary(fileName);

		String letters = new String(args[1]);

		Permutations test = new Permutations(letters);
		test.getAllWords(dictionary, "", letters);
		System.out.println("Found " + test.getWords().size() + " words");
		
		// "for each string s in test's words array, print it out"
		for (String s : test.getWords()) {
			System.out.println(s);
		}
	}
}