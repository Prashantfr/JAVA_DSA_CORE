//problem link : https://leetcode.com/problems/copy-list-with-random-pointer/description/
//problem name : Copy List with Random Pointer

//brute force solution with time complexity of O(n) and space complexity O(n).

package Linked_List;
/*import java.util.*;

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
}*/

//Optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
  }
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node temp = head;

        // Step 1: insert copy nodes
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: separate lists
        Node dummy = new Node(0);
        Node copyTail = dummy;
        temp = head;

        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next;

            copyTail.next = copy;
            copyTail = copy;

            temp = temp.next;
        }

        return dummy.next;
    }
}
