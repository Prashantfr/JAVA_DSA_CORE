//problem link:https://leetcode.com/problems/subarrays-with-k-different-integers/
//problem name : Subarrays with K Different Integers

//brute force solution with time complexity of O(n^2) and space complexity O(k).
package TwoPointers_SlidingWindow;

/*import java.util.HashSet;
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n; j++){
                set.add(nums[j]);

                if(set.size()==k){
                    count++;
                }
                else if(set.size()>k){
                    break;
                }
            }
        }
        return count;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(k).

import java.util.HashMap;
class Solution {
    public int atMostK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right=0; right<n; right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            int len = right-left+1;
            count += len;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k){
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
}
