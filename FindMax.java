import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindMax {
	// initialize copies of our two primary HashMaps
	HashMap<String, Integer> words = new HashMap<>();
	HashMap<Character, Integer> letters = new HashMap<>();
	
	public FindMax(HashMap<String, Integer> map1, HashMap<Character, Integer> map2) {
		words = map1;
		letters = map2;
	}
	
	/*
	 * Frequency Analysis on the letters HashMap
	 * Process follows as such:
	 * 	 - Get max value key in the map
	 * 	 - Add key to a separate array of size 10 to maintain descending order
	 * 	 - Print key and value
	 * 	 - Remove key to allow for new maximum value
	 * 	 - Return key array
	 */
	public char[] topTenLetters() {
		HashMap<Character, Integer> temp = letters;
		char[] res = new char[10];
		
		System.out.println("10 most frequently used letters (all letters were converted to lower case)");
		
		for(int i = 0; i < 10; i++) {
			char maxChar = Collections.max(temp.entrySet(), Map.Entry.comparingByValue()).getKey();
			res[i] = maxChar;
			System.out.println("Letter: " + res[i] + " frequency: " + temp.get(res[i]));
			temp.remove(maxChar);
		}
		
		System.out.println();
		
		return res;
	}
	
	/*
	 * Frequency Analysis on the words HashMap
	 */
	public String[] topTenWords() {
		HashMap<String, Integer> temp = words;
		String[] res = new String[10];
		
		System.out.println("10 most frequently used words");
		
		for(int i = 0; i < 10; i++) {
			String maxWord = Collections.max(temp.entrySet(), Map.Entry.comparingByValue()).getKey();
			res[i] = maxWord;
			System.out.println("Letter: " + res[i] + " frequency: " + temp.get(res[i]));
			temp.remove(maxWord);
		}

		System.out.println();
		
		return res;
	}
	
	/*
	 * Frequency Analysis on the words HashMap, merely with a title print change
	 */
	public String[] topTenWordsStop() {
		HashMap<String, Integer> temp = words;
		String[] res = new String[10];
		
		System.out.println("10 most frequently used words using stop list");
		
		for(int i = 0; i < 10; i++) {
			String maxWord = Collections.max(temp.entrySet(), Map.Entry.comparingByValue()).getKey();
			res[i] = maxWord;
			System.out.println("Letter: " + res[i] + " frequency: " + temp.get(res[i]));
			temp.remove(maxWord);
		}

		System.out.println();
		
		return res;
	}
}
