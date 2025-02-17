package com.exercise2.wei.tong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VowelNumber {
	
	public static int findVowel(List<Character> word, String vowels) {
		if(word.size() == 0) {
			return vowels.length();
		}
		char letter = word.get(0);
		if (letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u') {
			vowels += letter;
		}
		word.remove(0);   
		return findVowel(word,vowels);
	}
	public static void main(String[] args) {
		String myStr = "";
		try (Scanner getInputWord = new Scanner(System.in)) {
			System.out.println("Enter Word:");
			myStr = getInputWord.nextLine();  // Read user input
		}
		
		List<Character> charArray = myStr.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList()); ;	
	    int num = findVowel(charArray,"");
		System.out.println("Word " + myStr + " have " + num + " vowels.");
	}
}
