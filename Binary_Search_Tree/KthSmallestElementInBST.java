//problem link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
//problem name : Kth Smallest Element in a BST

//Recursive solution with time complexity of O(n) and space complexity O(h).

package Binary_Search_Tree;

class Solution {
        int count = 0;
        int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root , k);
        return ans;
    }

    private void inOrder(TreeNode node , int k){
        if(node == null) return;

        inOrder(node.left , k);

        count ++;

        if(count == k){
            ans = node.val;
            return;
        }

        inOrder(node.right , k);
    }
}
