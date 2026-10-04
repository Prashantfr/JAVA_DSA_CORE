//problem link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
//problem name : Flatten Binary Tree to Linked List

//Brute force solution with time complexity of O(n) and space complexity O(n)(extra list).

package Binary_Trees;
import java.util.*;

/*class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void preorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;

        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}*/

//Optimal solution with time complexity of O(n) and space complexity O(1).
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){

                TreeNode prev = curr.left;

                while(prev.right != null){
                    prev = prev.right;      //rightmost node of the left subtree
                }
                
                prev.right = curr.right; //Connecting the rightmost node of the left subtree to the right node of the root (connecting the left subtree to right subtree)

                curr.right = curr.left; //Connecting the root to the left subtree but as a right subtree

                curr.left = null; // removing the left subtree
            }
            curr = curr.right;
        }
    }
}