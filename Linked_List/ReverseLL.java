//problem link : https://leetcode.com/problems/reverse-linked-list/
//problem name : Reverse Linked List

//brute force solution with time complexity of O(N) and space complexity O(n) (extra space).

package Linked_List;
//import java.util.*;
/*class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}*/

//optimal solution with time complexity of O(N) and space complexity O(1).
//ITERATIVE

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while( curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        return prev;
    }
}
