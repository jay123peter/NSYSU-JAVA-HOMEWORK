package part1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Dictionary {

	public static void main(String[] args) {
		
		String testfilepath = "test.txt";
		String wordsfilepath = "words.txt";
		String line;
		StringTokenizer tokens;
		HashSet<String> dictionary = new HashSet<String>();
		HashSet<String> test = new HashSet<String>();

		try {
			
			//read words.txt store in hash set(dictionary)
			BufferedReader brwords = new BufferedReader(new InputStreamReader(new FileInputStream(wordsfilepath)));
			while((line = brwords.readLine()) != null){
				tokens = new StringTokenizer(line , " "); 
				while(tokens.hasMoreTokens()){
					String word;
					word = tokens.nextToken();
					dictionary.add(word);
				}
			}
			
			//read test.txt store in hash set(test)
			BufferedReader brtest = new BufferedReader(new InputStreamReader(new FileInputStream(testfilepath)));
			while((line = brtest.readLine()) != null){
				tokens = new StringTokenizer(line , " "); 
				while(tokens.hasMoreTokens()){
					String word;
					word = tokens.nextToken();
					test.add(word);
				}
			}
			
			brwords.close();
			brtest.close();
			
			//remove test words in dictionary
			Iterator<String> removeiterator = test.iterator();
			while(removeiterator.hasNext()){
				String tmp = removeiterator.next();
				if(dictionary.contains(tmp)){
					dictionary.remove(tmp);	
				}
				
			}
			
			//print final result
			Iterator<String> printiterator = dictionary.iterator();
			while(printiterator.hasNext()){
				String tmp = printiterator.next();
				System.out.println(tmp);
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found!!!");
			e1.printStackTrace();
			System.exit(1);
		} catch (IOException e2) {
			System.out.println("IO error!!!");
			e2.printStackTrace();
			System.exit(1);
		}

	}

}
