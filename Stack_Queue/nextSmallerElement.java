//problem link : https://takeuforward.org/plus/dsa/problems/next-smaller-element?source=strivers-a2z-dsa-track
//problem name : next smaller Element 

//brute force solution with time complexity of O(n) and space complexity O(n).

package Stack_Queue;
import java.util.Stack;

class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
