package edu.gcu.cst235.test;

import edu.gcu.cst235.service.worker.BibleWorker;

public class TestService {

	/**
	 * main method is for local testing only - commented out for web application
	 * @param args the command line arguments array
	 */
	public static void main(String[] args) {
		String searchWord = "God";
		System.out.println("Number of times " + searchWord + " appeared: " + BibleWorker.searchTextForWord(searchWord));
	}

}
