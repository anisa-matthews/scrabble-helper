
import java.util.ArrayList;

/** This class is used to make sequences of letters from which the words should be constructed. 
 * This class constructs all the words and permutations 
 * 
 * @author Anisa Matthews**/

public class Permutations {

	private String letters;
	private ArrayList<String> permutations = new ArrayList<String>();
	private ArrayList<String> words = new ArrayList<String>();

	/** Permutations
	 * Constructor method that makes sure the given letters contain appropriate characters
	 * before making permutations and words out of them. 
	 * 
	 * @param letters letters to make permutations out of later
	 * 
	 * @throws IllegalArgumentException if the letters contain a character not in the alphabet
	 */
	public Permutations(String letters) throws IllegalArgumentException {
		/*
		 * to make sure letters contains appropriate letters: character has the
		 * '.isLetter' method that can be used to determine if each letter is in
		 * the alphabet or not. if not in abc -> throw exception
		 */
		for (int i = 0; i < letters.length(); i++) {
			if (!Character.isLetter(letters.charAt(i))) {
				throw new IllegalArgumentException("This word contains characters not in the alphabet");
			}
		}
		this.letters = letters;
	}

	/** getAllPermutations
	 * method computes and returns a list of all PERMUTATIONS made with the letters.
	 * 
	 * @param fixed represents the characters in a permutation 
	 * that are 'fixed' or are not going to be shifted
	 * @param nonFixed represents the characters in a permutation
	 * that are 'non-fixed' and are going to be shifted
	 * @return an array of permutations
	 * @throws OutOfMemoryError if there are too many permutations to calculate
	 */
	public ArrayList<String> getAllPermutations(String fixed, String nonFixed) throws OutOfMemoryError {
		
		// base case -> when there are no more letters - > nonfixed = ""
		if (nonFixed.isEmpty()) {
			// check if it's already been added
			if (!isADuplicate(fixed + nonFixed, permutations))
				permutations.add(fixed + nonFixed);
		} else {
			for (int i = 0; i < nonFixed.length(); i++) {
				String newFixed = fixed + nonFixed.charAt(i);
				String newNonFixed = nonFixed.substring(0, i) // everything
																// before fixed
						+ nonFixed.substring(i + 1, nonFixed.length()); // everything
																		// after
																		// fixed
				getAllPermutations(newFixed, newNonFixed);
			}
		}
		return permutations;
	}

	/** isADuplicate
	 * checks if a permutation made is already in the array list before adding
	 * 
	 * @param permutation that was made from letters
	 * @param array of permutations
	 * @return true if the permutation made is already in the array -> is a duplicate.
	 * false otherwise
	 */
	private boolean isADuplicate(String permutation, ArrayList<String> array) {

		boolean isDouble = false;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).equalsIgnoreCase(permutation)) {
				isDouble = true;
			}
		}
		return isDouble;
	}

	/** getAllWords
	 * method computes and returns a list of WORDS found in the dictionary
	 * made with the letters
	 * 
	 * @param dictionary the array of words representing our 'dictionary'
	 * @param fixed characters in a permutations that are not going to be shifted
	 * @param nonFixed characters in a permutations that are going to be shifted
	 * @return an array of words that can be made from letters
	 * @throws OutOfMemoryError if there are too many words to calculate
	 */
	public ArrayList<String> getAllWords(Dictionary dictionary, String fixed, String nonFixed) throws OutOfMemoryError {

		if (nonFixed.isEmpty()) {
			// check if it's already been added
			if (!isADuplicate(fixed + nonFixed, words))
				words.add(fixed + nonFixed);
		} else {
			for (int i = 0; i < nonFixed.length(); i++) {
				String newFixed = fixed + nonFixed.charAt(i);
				//  if the new fixed string is a valid prefix, move on with the recursion
				if (dictionary.isPrefix(newFixed)) {
					String newNonFixed = nonFixed.substring(0, i) // everything before fixed
							+ nonFixed.substring(i + 1, nonFixed.length()); // everything after fixed
					getAllWords(dictionary, newFixed, newNonFixed);
				}
			}
		}
		return words;

	}

	/**getLetters
	 * @return string letters
	 */
	public String getLetters() {
		return letters;
	}	
	/**getPermutations
	 * 
	 * @return array of permutations
	 */
	public ArrayList<String> getPermutations() {
		return permutations;
	}
	/**getWords
	 * 
	 * @return array of words
	 */
	public ArrayList<String> getWords() {
		return words;
	}
}