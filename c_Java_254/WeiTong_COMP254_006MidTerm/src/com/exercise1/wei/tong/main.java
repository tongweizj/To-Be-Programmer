package com.exercise1.wei.tong;

public class main {
	// sort
	// An optimized version of Bubble Sort 
	static void bubbleSort(int[] arr) {
	    int n = arr.length;
	    boolean swapped;
	  
	    for (int i = 0; i < n - 1; i++) {
	        swapped = false;
	        for (int j = 0; j < n - i - 1; j++) {
	            if (arr[j] > arr[j + 1]) {
	            	int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j+1] = temp;
	                swapped = true;
	            }
	        }
	      
	        // If no two elements were swapped, then break
	        if (!swapped)
	            break;
	    }
	}
	static void printArr(int[] arr) {
	    for (int num : arr)
	        
	        System.out.print(num + " ");	
	}
	// build array
	
	
	// find 5 thing number
	static int findNum(int[] arr) {
		int check = 5;
		int numFind=0;
		int point =0;
		for(int num : arr) {
			
			if(num == point) {
				numFind ++;
			}else {
				point = num;
				numFind = 1;
			}
			if(numFind == check) {
				return point;
			}
			//System.out.print("\n num = " + num + "point = "+ point + "numFind = " + numFind );	
		}
		return 0;
	}
	
	  // name: Wei Tong 
	  // Student Number: 301034450
	  public static void main(String[] args) 
	  {
		  int[] tempArr= {4,7,9,1,9,9,9,9,9,100,333,100,100,100};
		  bubbleSort(tempArr);
		  printArr(tempArr);
		  int num = findNum(tempArr);
		  System.out.print("\n num = " + num);	
	  }

}
