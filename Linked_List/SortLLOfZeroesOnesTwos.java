//problem link : https://takeuforward.org/plus/dsa/problems/sort-a-ll-of-0's-1's-and-2's?source=strivers-a2z-dsa-track
//problem name : Sort a Linked List of 0's 1's and 2's

//Solution with time complexity of O(N) and space complexity O(1).
//Dutchflag pattern

package Linked_List;

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode zeroDummy = new ListNode(0);
        ListNode oneDummy = new ListNode(0);
        ListNode twoDummy = new ListNode(0);

        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twoDummy;

        ListNode curr = head;
        while(curr != null){
            if(curr.val == 0){
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.val == 1){
                one.next = curr;
                one = one.next;
            }
            else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        return zeroDummy.next;
    }
}
