#########################
# Maxim Gorshkov
# www.mgorshkov.com
# Project Euler Problem 34
# Comments: since you're only calculating factorials
#           up to 9! its not bad at 0.273s. Random guess
#           at the upper bound based on a previous PE prob.
#           Also, first 'real' program in python don't judge
#           me too, too hard.
########################

#define imports, only math libs in our case...
import math

#factorial function evaluates the... you guessed it... factorail
def fact(inVal):
    tempSum = 0
    tempNumber = inVal
    #probably a better way to do this.. oh well
    #we use integer divison and modulo to get the digits
    while tempNumber:
        digit = tempNumber % 10
        tempSum = tempSum + math.factorial(digit)
        tempNumber /= 10
    return tempSum #return the sum of digits

#main method...
def main():
    #define the bounds as necessary... guessed at upper bound based
    #on problem 21
    start = 3
    totalSum = 0

    while start < 100000:
        startFactorial = fact(start)
        if startFactorial == start:
            totalSum = totalSum + start
            print str(start) + ' works!' #print ones that work...
        start = start + 1
    #and after iterating, print total sum...
    print 'Total Sum '+ str(totalSum)

#the interwebs tell me this is good practice ;)
if __name__ == "__main__":
    main()
