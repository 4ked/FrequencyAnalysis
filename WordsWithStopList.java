import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordsWithStopList {
	HashMap<String, Integer> words = new HashMap<>();
	
	public WordsWithStopList(HashMap<String, Integer> map) {
		words = map;
	}
	
	/*
	 * Removes all words from words HashMap that align with the stop list
	 */
	public HashMap<String, Integer> process() {
		// create array of all words in stop list
		
		Scanner sc;
		try {
			sc = new Scanner(new File("stop-list.txt"));
			
			ArrayList<String> stopList = new ArrayList<String>();
			while(sc.hasNext()){
			    stopList.add(sc.next());
			}
			sc.close();
			
			// for word w in stop list, if HashMap contains w, remove it
			for(String w: stopList) {
				if(words.containsKey(w)) {
					words.remove(w);
				}
			}
			
			return words;
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the stop-list.txt file cannot be found: " + e);
		}
		
		return null;
	}
}
