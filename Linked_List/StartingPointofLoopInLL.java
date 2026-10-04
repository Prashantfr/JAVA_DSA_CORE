//problem link : https://leetcode.com/problems/linked-list-cycle-ii/description/
//problem name : Linked List Cycle 2

//brute force solution with time complexity of O(n) and space complexity O(n) (Extra Space).

package Linked_List;

//import java.util.*;

/*public class StartingPointofLoopInLL  {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while( temp != null ){
            if(set.contains(temp)){
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}*/

//optimal solution with time complexity of O(N) and space complexity O(1).

public class StartingPointofLoopInLL {
    public ListNode detectCycle(ListNode head) {
        
        if( head == null || head.next == null ){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
