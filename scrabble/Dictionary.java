import java.io.*;
import java.util.*;

/** This class provides a means of taking in a dictionary text file to find words in said dictionary 
 * using the given arrangement of letters**/
public class Dictionary {

	ArrayList<String> dictionary = new ArrayList<String>();

	/** Dictionary
	 * Constructor method that populates the array list dictionary with the words stored in the file
	 * 
	 * @param f is the dictionary file to read
	 * 
	 * @throws an IllegalArgumentException if the dictionary file cannot be found or read**/
	public Dictionary(File f) throws IllegalArgumentException {
		// Dictionary should be populated w the words stored in the file.
		if (!f.canRead()) {
			throw new IllegalArgumentException("This file is not readable");
		}
		try {
			Scanner scan = new Scanner(f);
			while (scan.hasNextLine()) {
				dictionary.add(scan.nextLine());
			}
			scan.close();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("This dictionary file can not be found");
		}
	}

	/** getDictionary
	 * Grabs and @return dictionary array 
	 * **/
	public ArrayList<String> getDictionary() {
		return dictionary;
	}

	/** isWord
	 * wrapper method for wordSearch
	 * 
	 * @param str
	 * @return true if string str is in the dictionary
	 * false otherwise
	 */
	public boolean isWord(String str) {
		// see wordSearch
		int start = 0;
		int end = dictionary.size();
		return wordSearch(str, dictionary, start, end);
	}

	/** wordSearch
	 * checks if string str is in dictionary
	 * 
	 * @param str string of letters to find
	 * @param array the dictionary array with all 'words'
	 * @param startIndex where to begin the binary search
	 * @param endIndex where to end the binary search
	 * @return true if string str is in dictionary
	 * false otherwise
	 */
	public boolean wordSearch(String str, ArrayList<String> array, int startIndex, int endIndex) {
		//checks if word is in dictionary
		if (startIndex > endIndex) {
			return false;
		}
		int midIndex = (startIndex + endIndex) / 2;
		if (str.compareToIgnoreCase(array.get(midIndex)) == 0)
			return true;
		else if (str.compareToIgnoreCase(array.get(midIndex)) < 0)
			return wordSearch(str, array, startIndex, (midIndex - 1));
		else
			return wordSearch(str, array, (midIndex + 1), endIndex);
	}

	/** isPrefix
	 * wrapper method for prefixSearch
	 * 
	 * @param str prefix string
	 * 
	 * @return true if str is a prefix for some word in the dictionary
	 * false otherwise.
	 * **/
	public boolean isPrefix(String str) {
		
		int start = 0;
		int end = dictionary.size();
		return prefixSearch(str, dictionary, start, end);
	}

	/** prefixSearch
	 * checks if string pfx is a prefix of some word in the dictionary using a binary search,
	 * 
	 * @param pfx prefix string
	 * @param array array of 'words' in the dictionary
	 * @param startIndex where to begin the binary search
	 * @param endIndex where to end the binary search
	 * @return true if pfx is a prefix of some word in the dictionary array
	 * false otherwise
	 */
	public boolean prefixSearch(String pfx, ArrayList<String> array, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return false;
		}
		int midIndex = (startIndex + endIndex) / 2;
		if (array.get(midIndex).startsWith(pfx))
			return true;
		else if (pfx.compareToIgnoreCase(array.get(midIndex)) < 0)
			return prefixSearch(pfx, array, startIndex, midIndex - 1);
		else
			return prefixSearch(pfx, array, midIndex + 1, endIndex);
	}
}
