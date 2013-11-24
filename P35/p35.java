/*
 * Maxim Gorshkov
 * www.mgorshkov.com
 * Project Euler Problem #35
 */

import java.io.*;
import java.util.*;

public class p35 {
	public static void main(String[] args) {
		int check = 1000000; // default 100
		checkUnder(check);
	}

	public static void checkUnder(int n) {
		int total = 0;
		int i = 2; // default 2
		while (i <= n) {
			if (isPrime(i)) {
				if (isCircular(i)) {
					total++;
					System.out.println(i+" works...");
				}
			}
			i++;
		}
		System.out.println(total);
	}

	public static boolean isPrime(int n) {
		int i = 3;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		while (i <= ((Math.pow(n, 0.5)) + 1)) {
			if (n % i == 0) {
				return false;
			}
			i += 2;
		}
		return true;
	}

	public static boolean isCircular(int n) {
		int preserve = n;
		
		if(n<10){
			if(isPrime(n)){
				return true;
			}
		}
		
		do{
			int temp = n % 10;
			n = n / 10;
			String nString = Integer.toString(n);
			String nTemp = Integer.toString(temp);
			nString = nTemp + nString;
			n = Integer.parseInt(nString);
			if (isPrime(n) == false) {
				return false;
			}
		}while((n != preserve));
		
		return true;
	}
}
