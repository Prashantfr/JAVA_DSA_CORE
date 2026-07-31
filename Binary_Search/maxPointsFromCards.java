//brute force with time complexity => O(k²) and space complexity of O(1).
package Binary_Search;

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
}