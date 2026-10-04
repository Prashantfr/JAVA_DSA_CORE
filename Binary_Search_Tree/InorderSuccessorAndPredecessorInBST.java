//problem link : https://takeuforward.org/practice/dsa/inorder-successor-and-predecessor-in-bst
//problem name : Inorder successor and predecessor in BST

//Solution with time complexity of O(h)(height of tree) and space complexity O(1)(no recursion).

package Binary_Search_Tree;

class Solution {
    
    public int[] findPreSuc(TreeNode root, int key) {
        
        TreeNode pre = null;
        TreeNode suc = null;
        
        TreeNode curr = root;
        
        while (curr != null) {
            
            if (curr.val < key) {
                pre = curr;          // possible predecessor
                curr = curr.right;   // go right
            }
            else if (curr.val > key) {
                suc = curr;          // possible successor
                curr = curr.left;    // go left
            }
            else {
                // found the key
                
                // find predecessor (max in left subtree)
                if (curr.left != null) {
                    TreeNode temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre = temp;
                }
                
                // find successor (min in right subtree)
                if (curr.right != null) {
                    TreeNode temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc = temp;
                }
                
                break;
            }
        }
        
        int p = (pre == null) ? -1 : pre.val;
        int s = (suc == null) ? -1 : suc.val;
        
        return new int[]{p, s};
    }
}