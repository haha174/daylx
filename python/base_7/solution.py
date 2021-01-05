##
#https://leetcode.com/problems/base-7/

#Given an integer, return its base 7 string representation.
#
#Example 1:
#Input: 100
#Output: "202"
#Example 2:
#Input: -7
#Output: "-10"
##
class Solution:
    def convertToBase7(self, num: int) -> str:
        res = ''
        n = abs(num)
        while n:
            res = str(n % 7) + res
            n =(int)(n/7)
        return '-' * (num < 0) + res or "0"


if __name__ == '__main__':
        num=0
        print('-' * (num < 0) + '' or "0")
        #print(Solution.convertToBase7(None,109))
