//problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//problem name : Lowest Common Ancestor of a Binary Search Tree 

//Solution with time complexity of O(n) and space complexity O(h).

package Binary_Search_Tree;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
