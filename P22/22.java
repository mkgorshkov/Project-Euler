/** 
 * 
 * @author Maxim Gorshkov
 * @URL www.mgorshkov.com
 * Problem #22 Project Euler
 * Link to problem: http://projecteuler.net/problem=22
 * 
 * Problems: still relatively slow at 11 seconds or so... it works!
 */

import java.io.*;
import java.util.*;

// check to see if you can actually execute the function, ie.
// if the file actually exists...

public class twentytwo {
	public static void main(String[] args) {
		try {
			sortList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//in the function below, make sure to specify where the file is based
//on the location of the java files...
	public static void sortList() throws IOException {
		File myFile = new File("D:\\McGill\\Fall2011\\COMP250\\Eclipse\\Problem22\\src\\names.txt");
		Scanner input = new Scanner(myFile).useDelimiter("\",\"");
		long start = System.currentTimeMillis(); //just to see time runnning...
		System.out.println("Starting to input names into array...");
		
		//by using this idea of delimiters,
		//the only problem is with the first and last entry...
		//we have "firstname.....lastname"
		
		String[] names = new String[5163];
		
		//we can cut at the quotation marks as necessary...
		int n = 0;
		while(input.hasNextLine()){
			String temp = input.next();
			if(temp.contains("\"") && n == 0){
				temp = temp.substring(1);
			}
			if(temp.contains("\"")){
				temp=temp.substring(0, temp.length()-1);
			}
			names[n] = temp;
			//System.out.println(temp);
			n++;
		}
		input.close();	
		System.out.println("Names stored: "+n);
		System.out.println("Starting to sort alphabetically...");
		
		Arrays.sort(names);
		System.out.println("Sorted alphabetically. Finding values of names.");
		calculateValues(names);
		long end = System.currentTimeMillis();
		long timeTaken = end - start;
		System.out.println("Solution took: "+timeTaken+"ms");
	}
	// loop to see the values of the letters based on the alphabet
	// there's probably a better way...
	public static void calculateValues(String[] names){
		int[] values = new int[5163];
		
		for(int i = 0; i < names.length; i++){
			int tempSum = 0;
			String temp = names[i];
			char[] tempChar = temp.toCharArray();
			for(int j = 0; j<tempChar.length; j++){
				if(tempChar[j] == 'A'){
					tempSum += 1;
				}
				if(tempChar[j] == 'B'){
					tempSum += 2;
				}
				if(tempChar[j] == 'C'){
					tempSum += 3;
				}
				if(tempChar[j] == 'D'){
					tempSum += 4;
				}
				if(tempChar[j] == 'E'){
					tempSum += 5;
				}
				if(tempChar[j] == 'F'){
					tempSum += 6;
				}
				if(tempChar[j] == 'G'){
					tempSum += 7;
				}
				if(tempChar[j] == 'H'){
					tempSum += 8;
				}
				if(tempChar[j] == 'I'){
					tempSum += 9;
				}
				if(tempChar[j] == 'J'){
					tempSum += 10;
				}
				if(tempChar[j] == 'K'){
					tempSum += 11;
				}
				if(tempChar[j] == 'L'){
					tempSum += 12;
				}
				if(tempChar[j] == 'M'){
					tempSum += 13;
				}
				if(tempChar[j] == 'N'){
					tempSum += 14;
				}
				if(tempChar[j] == 'O'){
					tempSum += 15;
				}
				if(tempChar[j] == 'P'){
					tempSum += 16;
				}
				if(tempChar[j] == 'Q'){
					tempSum += 17;
				}
				if(tempChar[j] == 'R'){
					tempSum += 18;
				}
				if(tempChar[j] == 'S'){
					tempSum += 19;
				}
				if(tempChar[j] == 'T'){
					tempSum += 20;
				}
				if(tempChar[j] == 'U'){
					tempSum += 21;
				}
				if(tempChar[j] == 'V'){
					tempSum += 22;
				}
				if(tempChar[j] == 'W'){
					tempSum += 23;
				}
				if(tempChar[j] == 'X'){
					tempSum += 24;
				}
				if(tempChar[j] == 'Y'){
					tempSum += 25;
				}
				if(tempChar[j] == 'Z'){
					tempSum += 26;
				}
			}
			values[i] = tempSum;
		}
		printValues(values);
	}
	// just to print the array of names if necessary...
	public static void printArray(String[] names){
		for(int i = 0; i<names.length; i++){
			System.out.println(names[i]);
		}
	}
	// to finally print the values...
	public static void printValues(int[] values){
		int totalSum = 0;
		int n = 0;
		for(int i = 0; i<values.length; i++){
			totalSum += (values[i] *(i+1));
			n++;
		}
		System.out.println(totalSum);
		System.out.println("Of the total"+n);
	}
}
