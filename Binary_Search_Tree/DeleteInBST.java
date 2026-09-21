//problem link : https://leetcode.com/problems/delete-node-in-a-bst/description/
//problem name : Delete node in Binary Search Tree. 

//Solution with time complexity of O(h)(height of tree) and space complexity O(h)(recursion stack).

package Binary_Search_Tree;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left , key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right , key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode succ = findMin(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right , succ.val);
        }
        return root;
    }
    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}