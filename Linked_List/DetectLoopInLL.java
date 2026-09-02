//problem link : https://leetcode.com/problems/linked-list-cycle/description/
//problem name : Linked List Cycle

//brute force solution with time complexity of O(N) and space complexity O(n) (Extra Space).


package Linked_List;
import java.util.*;

/*public class DetectLoopInLL {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while( temp != null ){
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
}*/

//optimal solution with time complexity of O(N) and space complexity O(1).
public class DetectLoopInLL {
    public boolean hasCycle(ListNode head) {
        if( head==null || head.next==null ){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}