//problem link : https://leetcode.com/problems/odd-even-linked-list/description/
//problem name : Odd Even Linked List

//brute force solution with time complexity of O(N) and space complexity O(N).

package Linked_List;
/*import java.util.*;

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null) return null;

        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();
        

        ListNode temp = head;
        int index = 1;
        while(temp != null){
            if(index%2 != 0){
                oddList.add(temp.val);
            }
            else{
                evenList.add(temp.val);
            }
            temp = temp.next;
            index++;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for(int i=0; i<oddList.size(); i++){
            int val = oddList.get(i);
            current.next = new ListNode(val);
            current = current.next;
           } 

        for(int i=0; i<evenList.size(); i++){
            int val = evenList.get(i);
            current.next = new ListNode(val);
            current = current.next;
            }
        return dummy.next;
    }
}*/

//Optimal solution with time complexity of O(N) and space complexity O(N).
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
            }
        odd.next = evenHead;
        return head;
     }
}