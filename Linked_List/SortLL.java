//problem link : https://leetcode.com/problems/sort-list/
//problem name : Sort Linked List

//brute force solution with time complexity of O(n log n) and space complexity O(n).

package Linked_List;
/*import java.util.*;

class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);

        ListNode curr = head;

        for(int i=0; i<arr.size(); i++){
            curr.val = arr.get(i);
            curr = curr.next;
        }
        return head;
    }
}*/

//Optimal solution with time complexity of O(n log n) and space complexity O(log n).
//Using merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null) temp.next = l1;
        if(l2 != null) temp.next = l2;

        return dummy.next;
    }
}
