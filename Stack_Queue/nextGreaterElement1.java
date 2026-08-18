//problem link : https://leetcode.com/problems/next-greater-element-i/description/
//problem name : Next Greater Element I

//brute force solution with time complexity of O(n * m) and space complexity O(1).
//declare the j variable outside the second for loop so that the third loop can use the value of j.

package Stack_Queue;
/*class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            int target = nums1[i];
            int j;

            for(j=0; j<nums2.length; j++){
                if(nums2[j] == target) break;
            }

            int nextGreater = -1;
            for(int k=j+1; k<nums2.length; k++){
                if(nums2[k] > target){
                    nextGreater = nums2[k];
                    break;
                }
            }
            result[i] = nextGreater;
        }
        return result;
    }
}*/

//optimal solution with time complexity of O(n + m) and space complexity O(n).
import java.util.Stack;
import java.util.HashMap;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--){
            int num = nums2[i];

            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(num , -1);
            }
            else{
                map.put(num , stack.peek());
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}