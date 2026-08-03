//problem link : https://leetcode.com/problems/fruit-into-baskets/
//brute force solution with time complexity of O(n^2) and space complexity O(1).

package TwoPointers_SlidingWindow;
import java.util.HashSet;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(fruits[j]);

                if(set.size()>2){
                    break;
                }

                int len = j-i+1;
                maxLen = Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}
