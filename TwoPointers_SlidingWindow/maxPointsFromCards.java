//Problem Link : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
//brute force with time complexity => O(k²) and space complexity of O(1).
/*package Binary_Search;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;

        for(int i=0; i<=k; i++){
            int leftSum = 0;
            int rightSum = 0;

            for(int j=0; j<i; j++){
                leftSum += cardPoints[j];
            }

            for(int j=0; j<k-i; j++){
                rightSum += cardPoints[n-1-j];
            }

            maxSum = Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
}*/

//optimal solution with time complexity => O(k) and space complexity of O(1).
package TwoPointers_SlidingWindow;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        for(int i= 0; i<n; i++){
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;
        int rightSum = 0;

        for(int i=0; i<=k; i++){
            leftSum -= cardPoints[k-i];
            rightSum += cardPoints[n-i];

            int sum = leftSum + rightSum;
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
