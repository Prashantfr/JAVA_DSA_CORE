//problem link : https://leetcode.com/problems/powx-n/description/
//problem name : Pow(x, n)
//brute force solution with time complexity of O(n) and space complexity O(1).
//simply multiply the x , n times.

package Recursion;

class Solution {
    public double myPow(double x, int n) {
        
        long power = n;
        
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        for (long i = 0; i < power; i++) {
            result = result * x;
        }

        return result;
    }
}
