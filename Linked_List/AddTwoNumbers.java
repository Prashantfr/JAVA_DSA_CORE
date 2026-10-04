//problem link : https://leetcode.com/problems/add-two-numbers/description/
//problem name : Add Two Numbers

//Solution with time complexity of O(max(n, m)) , space complexity O(max(n, m)) and auxiliary space O(1).

package Linked_List;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;
        }
        return dummy.next;
    }
}