package edu.gcu.cst235.worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BibleWorker {

	/**
	 * main method is for local testing only - commented out for web application
	 * @param args the command line arguments array
	 */
//	public static void main(String[] args) {
//		String searchWord = "condemnation";
//		System.out.println("Number of times " + searchWord + " appeared: " + searchTextForWord(searchWord));
//	}
	
	/**
	 * searches for the searchWord in the referenced file
	 * @param searchWord
	 * @return the number of times the word occurs in the file (case sensitive)
	 */
	public static int searchTextForWord(String searchWord) {
		//The file to search
		File file = new File("/Users/roy/Dropbox/0-GCUJavaBootcamp/cst235/restfulsearchbenchmark/romans8.txt");
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
