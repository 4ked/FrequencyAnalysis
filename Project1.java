/**
 * @author Max Goeke
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		
		HashMap<Character, Integer> LetterMap = new HashMap<>();
		HashMap<String, Integer> WordMap = new HashMap<>();
		WordsWithStopList WordStopListMap;
		
		int count = 0;
		
		Scanner sc;
		try {
			sc = new Scanner(new File("tom-sawyer.txt"));
			ArrayList<String> fileLines = new ArrayList<String>();
			while(sc.hasNextLine()){
			    fileLines.add(sc.nextLine());
			}
			
			for(String line: fileLines) {
				sc = new Scanner(line);
				while(sc.hasNext()) {
					sc.useDelimiter("[^a-zA-Z']");
					
					String word = sc.next();
					word = word.toLowerCase();
					word = word.replaceAll("^'+", "");
					word = word.replaceAll("'+$", "");
					
					/* Process words into HashMaps */
					if(!word.equals("")) {
						/* Place word in WordMap */
						if(WordMap.containsKey(word))
							WordMap.put(word, WordMap.get(word) + 1);
						else
							WordMap.put(word, 1);
					    
					    /* Place letters in letter map */
						for(Character c: word.toCharArray()) {
							// eliminate ' character from list (39 = ascii value), add to wildcard count
							if(c != 39) {
								if(LetterMap.containsKey(c))
									LetterMap.put(c, LetterMap.get(c) + 1);
								else
									LetterMap.put(c, 1);
							} else {
								count++;
							}
						}
					}
					
				}
			}
			
			sc.close();
			
			// perform frequency analysis on each HashMap
			FindMax frequencyAnalysis = new FindMax(WordMap, LetterMap);
			frequencyAnalysis.topTenLetters();
			frequencyAnalysis.topTenWords();
			
			//create HashMap of words minus those in the stop list
			WordStopListMap = new WordsWithStopList(WordMap);
			WordStopListMap.process();
			frequencyAnalysis.topTenWordsStop();
			
			System.out.println("(Wildcard) Number of middle apostraphe's: " + count);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, the provided book file could not be found: " + e);
		}
		
	}

}
