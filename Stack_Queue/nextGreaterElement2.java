//problem link : https://leetcode.com/problems/next-greater-element-ii/description/
//problem name : Next Greater Element II

//brute force solution with time complexity of O(n^2) and space complexity O(1) excluding output.

package Stack_Queue;

/*class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){

            ans[i] = -1;

            for(int j=1; j<n; j++){

                int idx = (i+j)%n;

                if(nums[idx]>nums[i]){
                    ans[i] = nums[idx];
                    break;
                }
            }
        }
        return ans;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(n).
import java.util.Stack;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            int num = nums[i%n];

            while(!st.isEmpty() && st.peek()<=num){
                st.pop();
            }

            if(i<n){
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
        }
        return ans;
    }
}

