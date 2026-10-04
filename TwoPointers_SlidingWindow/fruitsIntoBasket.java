//problem link : https://leetcode.com/problems/fruit-into-baskets/
//problem name : Longest subarray with atmost 2 distinct numbers/(fruits into basket).
//brute force solution with time complexity of O(n^2) and space complexity O(1).

package TwoPointers_SlidingWindow;
/*import java.util.HashSet;
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
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).

import java.util.HashMap;
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int maxLen = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int right=0; right<n; right++){

            map.put(fruits[right], map.getOrDefault(fruits[right] ,0) + 1);

            while(map.size()>2){

                map.put(fruits[left], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            int len = right-left+1;
            maxLen = Math.max(len, maxLen);

        }
        return maxLen;
    }
}
