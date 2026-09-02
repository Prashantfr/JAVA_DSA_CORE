//problem link : https://takeuforward.org/plus/dsa/problems/length-of-loop-in-ll?source=strivers-a2z-dsa-track
//problem name : Length of loop in LL

//brute force solution with time complexity of O(n) and space complexity O(n) (Extra Space).

package Linked_List;

/*import java.util.*;

class Solution {
    public int lengthOfLoop(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        int step = 0;

        ListNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return step - map.get(temp); // loop length
            }
            map.put(temp, step);
            temp = temp.next;
            step++;
        }

        return 0; // no loop
    }
}*/

//optimal solution with time complexity of O(n) and space complexity O(1).
 class Solution {
     public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return CountLoopLength(slow);
            }
        }
        return 0;
     }

     private int CountLoopLength(ListNode meetingpoint){
        int count = 1;
        ListNode temp = meetingpoint.next;
        while( temp!=meetingpoint ){
            count++;
            temp = temp.next;
        }
        return count;
     }
 }