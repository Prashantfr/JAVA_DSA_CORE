//problem link : https://takeuforward.org/plus/dsa/problems/length-of-loop-in-ll?source=strivers-a2z-dsa-track
//problem name : Length of loop in LL

//brute force solution with time complexity of O(n) and space complexity O(n) (Extra Space).

package Linked_List;

import java.util.*;

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
}