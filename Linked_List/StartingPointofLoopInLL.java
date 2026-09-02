//problem link : https://leetcode.com/problems/linked-list-cycle-ii/description/
//problem name : Linked List Cycle 2

//brute force solution with time complexity of O(n) and space complexity O(n) (Extra Space).

package Linked_List;

import java.util.*;

public class StartingPointofLoopInLL  {
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
}
