//problem link : https://leetcode.com/problems/rotate-list/
//problem name : Rotate Linked List by k places

//solution with time complexity of O(n) and space complexity O(1).

package Linked_List;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        int length = 1;
        while(curr.next != null){
            curr = curr.next;
            length++;
        }

        k = k % length;
        if(k == 0) return head;

        curr.next = head;

        int steps = length - k;
        ListNode newTail = head;
        for(int i=1; i<steps; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
