//problem link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
//problem name : Remove Nth Node From End of List

//brute force solution with time complexity of O(N)(two passes) and space complexity O(1).

package Linked_List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Step 1: Find length
        int length = 0;
        ListNode temp = head;
        
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Edge case (delete head)
        if (length == n) {
            return head.next;
        }
        
        // Step 3: Go to (length - n)th node (previous node)
        temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }
        
        // Step 4: Delete node
        temp.next = temp.next.next;
        
        return head;
    }
}
