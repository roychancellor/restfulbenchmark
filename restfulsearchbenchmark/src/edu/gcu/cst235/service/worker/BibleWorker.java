package edu.gcu.cst235.service.worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BibleWorker {
	/**
	 * searches for the searchWord in the referenced file
	 * @param searchWord
	 * @return the number of times the word occurs in the file (case sensitive)
	 */
	public static int searchTextForWord(String searchWord) {
		//The file to search
		File file = new File("/Users/roy/git/restfulbenchmark/restfulsearchbenchmark/romans8.txt");
		int wordCount = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(searchWord)) {
					wordCount++;
				}
			}
			br.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return wordCount;
	}
}
