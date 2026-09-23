//problem link : https://leetcode.com/problems/recover-binary-search-tree/description/
//problem name : Recover Binary Search Tree

//Solution with time complexity of O(n) and space complexity O(h)(tree height).

package Binary_Search_Tree;

class Solution {
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode curr){

        if(curr == null) return;

        inorder(curr.left);

        if(prev.val > curr.val){
            if(first == null){
                first = prev;
            }
            second = curr;
        }
        prev = curr;

        inorder(curr.right);
    }
}
