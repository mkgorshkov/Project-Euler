###############
# Maxim Gorshkov
# www.mgorshkov.com
# Project Euler Problem 13
# Running Time: 0.053s
##############


def sumText(path):
    inNum = open(path,"r")
    lineSum = 0

    line = inNum.readline()
    while line:
         lineSum  = lineSum + int(line)
         line = inNum.readline()

    answer = str(lineSum)
    answer = answer[0:10]

    inNum.close()
    print answer

def main():
    sumText("numbers.txt")
    
if __name__ == "__main__":
    main()
