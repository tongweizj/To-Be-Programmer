package com.exercise1.wei.tong;

import java.util.Scanner;

public class PrintStart {
	public static int printNum = 0;
	
	public static String printStart(int maxNum,  boolean isDown){
		// isDown = false, print more start
		// num, print start number
		
		if(printNum == 0 && isDown == true) {
			return "";
		}else {
			drawStar(printNum);
			
			if(isDown == false && printNum < maxNum) {
				printNum ++;
			}
			
			if(isDown == true &&printNum >0){
				printNum --;
			}
			
			if(printNum == maxNum && isDown == false) {
				isDown = true;
			}
			return printStart(maxNum,isDown);
		}
	}
	
	  private static void drawStar(int num) {
		    for(int j = 0; j < num; j++) {
		      System.out.print("*");
		      
		    }
		    System.out.print("\n");
		  }
	  
	  public static void main(String[] args) {
		  // get user input: start number
		  Scanner getDrawInput = new Scanner(System.in);  // Create a Scanner object
		  System.out.println("Enter Draw Start Number:");
		  String startnum = getDrawInput.nextLine();  // Read user input
		  System.out.println("Username is: " + startnum);  // Output user input
		  // printStart
		  printStart(Integer.parseInt(startnum),false);
	  }
}
