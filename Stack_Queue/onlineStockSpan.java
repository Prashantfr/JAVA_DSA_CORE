//problem link : https://leetcode.com/problems/online-stock-span/
//problem name : Online Stock Span

//brute force solution with time complexity of O(n^2) and space complexity O(n).

package Stack_Queue;
/*import java.util.List;
import java.util.ArrayList;
class StockSpanner {
    private List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int span = 1;
        for(int i = prices.size()-2; i>=0; i--){
            if(prices.get(i) <= price){
                span++;
            }
            else{
                break;
            }
        }
        return span;
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(n).
import java.util.*;
class StockSpanner {
    private List<Integer> prices;
    private Stack<Integer> stack;

    public StockSpanner() {
        prices = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int i = prices.size() - 1;

        while(!stack.isEmpty() && prices.get(stack.peek()) <= price){
            stack.pop();
        }

        int span;
        if(stack.isEmpty()){
            span = i + 1;
        }
        else{
            span = i - stack.peek();
        }
        stack.push(i);
        return span;
    }
}
