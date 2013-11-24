/** 
 * 
 * @author Maxim Gorshkov
 * @URL www.mgorshkov.com
 * Problem #37 Project Euler
 * Link to problem: http://projecteuler.net/problem=37
 * 
 * Problem: Terribly inefficient! But it works..... (Slow...like 4 minutes slow).
 */

import java.io.*;
import java.util.*;

public class thirtyseven {
	public static void main(String[] args){
		int n = 23;
		int index = 0;
		int array[] = new int[11];
		
		long start = System.currentTimeMillis();
		
		//we know from the specification of the question
		//that we have at most 11, so we might as well loop until
		//that point is reached.
		while(index<11){
			if((isPrime(n) == true) && (isPrimeRight(n) == true) && (isPrimeLeft(n) == true)){
				String temp = Integer.toString(n);
				if(!temp.startsWith("1")){
					array[index] = n;
					index++;
				}
				else{
					n++;
				}
			}
			n++;
		}

		long end = System.currentTimeMillis();
		long timeTaken = end - start;
		
		sumAndPrintArray(array);
		System.out.println("Solution took: "+timeTaken+"ms");
	}
	//check to see if it is, in fact a prime number
	//by checking if it is divisible by numbers between 2 and itself-1
	//if it is not, it must be prime...
	static boolean isPrime(int a){
		for(int i = 2; i<a; i++){
			if(a%i == 0){
				return false;
			}
		}
		return true;
	}
	//going from the right is simple integer division since we'll
	//truncate everything from the right as we go along
	//we call the isPrime() method to help as we go...
	static boolean isPrimeRight(int a){
		while(a != 0){
			if(isPrime(a) == false){
				return false;
			}
			else{
				a = a/10;
			}
		}
		return true;
	}
	//going from the left is a little more difficult
	static boolean isPrimeLeft(int a){
		int j = 0;
		String sizeTest = Integer.toString(a);
		char [] primeTest = sizeTest.toCharArray();
		
		
		while(j<primeTest.length){
			String crt = sizeTest.substring(j);
			int testThis = Integer.parseInt(crt);
				if((isPrime(testThis) == false) || (testThis == 1)){
					return false;
				}
				else{
					j++;
				}
		}
		return true;
	}
	static void sumAndPrintArray(int array[]){
		int sum = 0;
		for(int i = 0; i<array.length; i++){
			sum += array[i];
			System.out.println(array[i]);
		}
		System.out.println("Sum: "+sum);
	}
}
