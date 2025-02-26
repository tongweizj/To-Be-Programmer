package com.exercise3.wei.tong;

import java.util.Arrays;

public class main {
	//main method
	// recursive method 
	// for finding the minimum element in an array, A, of n elements. 
	// What the running time? 
	// Hint: an array of size 1 would be the stop condition. 
	// The implementation is similar to linearSum method in lecture 5 examples. 
	// You can use the Math.min method for finding the minimum of two numbers.
	
	  /** Returns the sum of the first n integers of the given array. */
	  public static int linearMin(int[] data, int small) {
	    if (data.length == 1) {
	    	if(data[0] < small || small ==-1) {
	    		small = data[0];
	    	}
	      return small;
	    }else
	    	if(small ==-1 ||data[0] < small ) {
	    		small = data[0];
	    	}
	        data = Arrays.copyOfRange(data, 1, data.length);    	
       	    return linearMin(data,small);
	    }
	  // name: Wei Tong 
	  // Student Number: 301034450
	  public static void main(String[] args) 
	  {
		  int[] tempArr= {9,100,400,3,200,500};
		  int num = linearMin(tempArr,-1);

		  System.out.print("\n num = " + num);	
	  }
}
