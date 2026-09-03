//problem link : https://leetcode.com/problems/palindrome-linked-list/description/
//problem name : Palindrome Linked List

//brute force solution with time complexity of O(N) and space complexity O(N).

package Linked_List;
/*import java.util.*;
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
}*/

//Optimal solution with time complexity of O(N) and space complexity O(1).
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);

        ListNode firstHalf = head;
        while(secondHalf != null){
            if(firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }    

        private ListNode reverse(ListNode curr){
            ListNode prev = null;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
         }
        return prev;
    }
}