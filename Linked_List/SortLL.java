//problem link : https://leetcode.com/problems/sort-list/
//problem name : Sort Linked List

//brute force solution with time complexity of O(n log n) and space complexity O(n).

package Linked_List;
import java.util.*;

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
}
