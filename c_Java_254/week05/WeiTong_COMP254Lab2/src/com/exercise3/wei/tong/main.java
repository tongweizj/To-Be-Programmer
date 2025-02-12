package com.exercise3.wei.tong;

public class main {
	public static void max(int []arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
	  public static int[] buildArray(int amount) {
		  int[] array = new int[amount];
		  for(int i = 0; i<amount;i++) {
			  array[i] = i;
		  }
		  return array;
	  }
	  public static void main(String[] args) {
		  int[] array = buildArray(20);
		  max(array);
		  int num = array.length-1;
		  int max = array[num];
		  System.out.println("Finding an integer that cannot be formed as the sum of two integers in array ：" + max*2);
	  }

}
