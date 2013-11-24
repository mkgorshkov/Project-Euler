/*
 * Maxim Gorshkov
 * www.mgorshkov.com
 * Project Euler Problem # 17
 * 
 * Running time: 108ms (0.108s)
 */

import java.io.*;
import java.util.*;

public class Problem17{
	public static int ones(int n){
		int sum = 0;
		
		if(n == 1 || n == 2 || n == 6){
			sum += 3;
		}
		else if(n == 4 || n == 5 || n == 9){
			sum += 4;
		}
		else if(n == 3 || n == 7 || n == 8){
			sum += 5;
		}
		return sum;
	}
	public static int tens(int n){
		int sum = 0;
		
		if (n == 10){
			sum += 3;
		}
		else if (n == 40 || n == 50 || n == 60){
			sum += 5;
		}
		else if(n == 11 || n == 12 || n == 20 || n == 30 || n == 80 || n == 90){
			sum += 6;
		}
		else if(n == 15 || n == 16 || n == 70){
			sum += 7;
		}
		else if(n == 13 || n == 14 || n == 18 || n == 19){
			sum += 8;
		}
		else if(n == 17){
			sum += 9;
		}
		return sum;
	}
	public static int calculate(int n){
		int sum = 0;
		int tempsum = 0;

		if(n == 1000){
			return 11;
		}
		if(n%100 == n){
			if(n/10 != 1){
				int hold = n/10;
				hold *= 10;
				tempsum += tens(hold);
				tempsum += ones(n%10);
			}
			else{
				tempsum += tens(n);
			}
		}
		else{
			int hold = n/100;
			tempsum += ones(hold);
			tempsum += 7; //for the 'hundred'
			
			if(n%100 != 0){
				tempsum += 3; //for the 'and'

				if((n%100)/10 != 1){
				int hold2 = (n%100)/10;
				hold2 *= 10;
				tempsum += tens(hold2);
				tempsum += ones((n%100)%10);
				}
				else{
				tempsum += tens(n%100);
				}
			}
		
		}

		sum = tempsum;
		return sum;
	}
	public static int passthrough(int n){
		int sum = 0;

		for(int i = 1; i<=n; i++){
			sum += calculate(i);
		}
		return sum;	
	}
	public static void main(String[] args){
		int n = 1000;
		int total = passthrough(n);
	
		System.out.println(total);
	}
}
