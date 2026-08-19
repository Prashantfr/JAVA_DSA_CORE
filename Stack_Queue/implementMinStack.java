//problem link : https://leetcode.com/problems/min-stack/
//problem name : Implement min stack

//solution with time complexity of O(1) and space complexity O(n).

package Stack_Queue;

import java.util.Stack;
class MinStack {
           private Stack<Integer> Stack;
           private Stack<Integer> minStack;
    public MinStack() {
        Stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        Stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        else{
            minStack.push(Math.min(value, minStack.peek()));
        }
    }
    
    public void pop() {
        Stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return Stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
