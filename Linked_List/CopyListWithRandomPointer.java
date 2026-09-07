//problem link : https://leetcode.com/problems/copy-list-with-random-pointer/description/
//problem name : Copy List with Random Pointer

//brute force solution with time complexity of O(n) and space complexity O(n).

package Linked_List;
import java.util.*;

class Solution{

    class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int val) {
        this.val = val;
        this.next = null;

    }
}
  
    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();

        ListNode temp = head;

        while(temp != null){
            map.put(temp, new ListNode(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            ListNode copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
