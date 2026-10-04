//problem link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
//problem name : Construct Binary Search Tree from Preorder Traversal

//brute force solution with time complexity of O(n²) and space complexity O(n).
//not valid

package Binary_Search_Tree;

/*class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder , int start , int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);

        int i = start+1;
        while(i <= end && preorder[i] < root.val){
            i++;
        }

        root.left = build(preorder , start+1 , i-1);

        root.right = build(preorder , i+1 , end);

        return root;
    }
}*/

//Optimal solution with time complexity of O(n) (each element used once) and space complexity O(h) (recursion (≈ O(log n) for balanced)).
class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder , int min , int max){

        if(i >= preorder.length) return null;

        int val = preorder[i];

        if(val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        i++;

        root.left = build(preorder , min , val);

        root.right = build(preorder , val , max);

        return root;
    }
}