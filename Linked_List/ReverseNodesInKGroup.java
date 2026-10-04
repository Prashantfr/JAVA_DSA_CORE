//problem link : https://leetcode.com/problems/reverse-nodes-in-k-group/description/
//problem name : Reverse Nodes in k-Group

//Solution with time complexity of O(n) and space complexity O(1).

package Linked_List;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;
            for(int i=0; i<k && kth!=null; i++){
                kth = kth.next;
            }
            if(kth == null) break;

            ListNode nextGroup = kth.next;

            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;
            while(curr != nextGroup){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }
}