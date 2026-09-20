//problem link : https://leetcode.com/problems/insert-into-a-binary-search-tree/description/?envType=problem-list-v2&envId=binary-tree
//problem name : Insert into a Binary Search Tree. 

//Recursive solution with time complexity of O(h) and space complexity O(n).

package Binary_Search_Tree;
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // base case: found position
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
}
