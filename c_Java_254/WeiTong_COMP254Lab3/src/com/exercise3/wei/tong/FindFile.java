package com.exercise3.wei.tong;

import java.io.File;
import java.util.Scanner;

public class FindFile {
	 public static String findFile(File path,String fileName) {
		 String name = "";
		 //System.out.println(fileName);
		 
	    if (path.isDirectory()) {                        
		      for (String childname : path.list()) {        
		    	  //System.out.println(childname);
		    	 
		    	  File child = new File(path, childname); 
		    	  if(child.isDirectory()){
		    		  name += findFile(child, fileName);
		    	  }else{
		    		  if(childname.equals(fileName)) {
		    			  // name += (child.getAbsolutePath() + "\n");
		    			  name += (child.getAbsolutePath());
		    		  }
		    	  }
		      }
		 }else {
		     //System.out.println(path.getAbsolutePath());
			 if(path.getName() == fileName ) {
			   	name += path.getAbsolutePath();
		     }
	    }
		    return name;          
		  }


	 
		  public static void main(String[] args) {
		    String start;
		    if (args.length > 0) {
		      start = args[0];
		    } else {
		    // test:D:\Workspace\Nodes_Code\c_Java_254\
		      System.out.print("Enter the starting location: ");
		      start = new Scanner(System.in).next();
		    }
		    String name = findFile(new File(start), "Lab Assignment 1.docx");
		    System.out.print("Result=\n" + name);
		  }
}
