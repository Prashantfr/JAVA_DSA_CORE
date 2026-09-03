//problem link : https://leetcode.com/problems/palindrome-linked-list/description/
//problem name : Palindrome Linked List

//brute force solution with time complexity of O(N) and space complexity O(N).

package Linked_List;
import java.util.*;
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(temp.val != stack.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
