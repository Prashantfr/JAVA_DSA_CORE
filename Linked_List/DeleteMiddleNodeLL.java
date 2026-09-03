//problem link : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
//problem name : Delete the Middle Node of a Linked List

//brute force solution with time complexity of O(N)(two passes) and space complexity O(1).

package Linked_List;

/*class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next==null){
            return null;
        }

        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        temp = head;
        for(int i=0; i<len/2-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}*/

//Optimal solution with time complexity of O(N)(single pass) and space complexity O(1).
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

