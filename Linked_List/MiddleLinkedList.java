//problem link : https://leetcode.com/problems/middle-of-the-linked-list/
//problem name : Middle of the Linked List

//brute force solution with time complexity of O(N)(two passes) and space complexity O(1).

package Linked_List;
import java.util.*;

public class MiddleLinkedList {

    class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
  }

    class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;

        while (temp != null){
            len++;
            temp = temp.next;
        }

        temp = head;
        for(int i=0; i<len/2; i++){
            temp = temp.next;
        }
        return temp;
    }
  }
 }

