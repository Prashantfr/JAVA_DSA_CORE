//problem link : https://leetcode.com/problems/powx-n/description/
//problem name : Pow(x, n)
//brute force solution with time complexity of O(n) and space complexity O(1).
//simply multiply the x , n times.

package Recursion;

/*class Solution {
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
}*/

//Optimal solution with time complexity of O(log n) and space complexity O(log n).
class Solution {
    public double myPow(double x, int n) {
        long pow = n;

        if(pow < 0){
            x = 1/x;
            pow = -pow;
        }

        double result = 1;

        while(pow > 0){
            if(pow % 2 == 1){
                result = result * x;
            }
            x = x * x;
            pow = pow/2;
        }
        return result;
    }
}