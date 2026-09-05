//problem link : https://takeuforward.org/plus/dsa/problems/add-one-to-a-number-represented-by-ll?source=strivers-a2z-dsa-track
//problem name : Add one to a number represented by LL

//brute force solution with time complexity of O(n) and space complexity O(n).

package Linked_List;

/*class Solution {
    public ListNode addOne(ListNode head) {
        // Step 1: Convert to number
        long num = 0;
        ListNode temp = head;

        while (temp != null) {
            num = num * 10 + temp.val;
            temp = temp.next;
        }

        // Step 2: Add 1
        num = num + 1;

        // Step 3: Convert back to LL
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        String str = String.valueOf(num);

        for (char c : str.toCharArray()) {
            curr.next = new ListNode(c - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}*/

//Optimal solution with time complexity of O(n) and space complexity O(1).
public class Add1toNumberRepresentedbyLL {
	public static ListNode addOne(ListNode head) {
		head = reverse(head);
		ListNode temp = head;
		int carry = 1;

		while(temp != null){
			int sum = temp.val + carry;
			temp.val = sum % 10;
			carry = sum/10;

		if(carry == 0) break;

		if(temp.next == null && carry!=0){
			temp.next = new ListNode(carry);
			carry = 0;
			break;
		}
		temp = temp.next;
	  }
	return reverse(head);
   }

   private static ListNode reverse(ListNode curr){
	   ListNode prev = null;
	   while(curr != null){
		   ListNode next = curr.next;
		   curr.next = prev;
		   prev = curr;
		   curr = next;
	   }
	   return prev;
   }
}
