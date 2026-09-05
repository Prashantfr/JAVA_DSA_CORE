//problem link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
//problem name : Intersection of Two Linked Lists

//brute force solution with time complexity of O(N × M) and space complexity O(1).

package Linked_List;

/*public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        
        while (a != null) {
            ListNode b = headB;
            
            while (b != null) {
                if (a == b) {   // same node (same memory)
                    return a;
                }
                b = b.next;
            }
            
            a = a.next;
        }
        
        return null; // no intersection
    }
}*/

//Optimal solution with time complexity of O(N + M) and space complexity O(1).
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            p1 = (p1==null) ? headB : p1.next;
            p2 = (p2==null) ? headA : p2.next;
        }
        return p1;
    }
}
