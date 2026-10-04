//problem link : https://leetcode.com/problems/count-good-numbers/description/
//problem name : Count Good Numbers

//Solution with time complexity of O(logn) and space complexity is O(1).

package Recursion;

class Solution {
    long mod = (long) 1e9 + 7;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long part1 = pow(5 , even);
        long part2 = pow(4 , odd);
        return (int)((part1 * part2) % mod);
    }

    public long pow(long base , long exp){
        long result = 1;

        while(exp > 0){
            if(exp % 2 == 1){
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }
}
