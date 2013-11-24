/*
 * Maxim Gorshkov
 * www.mgorshkov.com
 * Project Euler Problem # 21
 * Comments: no major complaints, pretty reasonable at ~0.5sec
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

int checkDivisors(double numberToCheck);
int checkAmicable(double numberToCheck);

//not super involved, iterate through as necessary
//check against the checkAmicable method... win.
int main(){
    double numberToCheck = 1;
    double sum = 0;
    while(numberToCheck <= 10000){
        if(checkAmicable(numberToCheck)){
            printf("%.f is amiacable\n",numberToCheck);
            sum += numberToCheck;
        }
        numberToCheck = numberToCheck + 1;
    }
    printf("Sum of \"Amicable Numbers\" number 10000: %.f",sum);
    return EXIT_SUCCESS;
}

//here we have the check to see if the number given
//at the beginning is in fact amicable since it is checked
//and returned 1 or 0...
int checkAmicable(double numberToCheck){
    int sumOfDivisors = checkDivisors(numberToCheck);
    int secondSumOfDivisors = checkDivisors((double)sumOfDivisors); 
    if((numberToCheck == secondSumOfDivisors) && (sumOfDivisors != secondSumOfDivisors)){
        return 1;
    }
    return 0;
}

//simple check to see divisors of number "numberToCheck"
int checkDivisors(double numberToCheck){
    int i; //index
    double remainder;
    int divisors = 0; //in case we wanna check how many divisors (debugging)
    int sumDivisors = 0; //sum of the divisors

    //loop through...
    for(i = 1; i <= numberToCheck/2; i++){
        remainder = fmod(numberToCheck, ((double)i));
        if(remainder == 0){
            sumDivisors += i;
            divisors++;
        }
    }
    return sumDivisors;
}
