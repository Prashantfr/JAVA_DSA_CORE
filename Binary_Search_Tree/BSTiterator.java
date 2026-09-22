//problem link : https://leetcode.com/problems/binary-search-tree-iterator/description/
//problem name : Binary Search Tree Iterator

//brute force solution with time complexity of Constructor (inorder traversal) → O(n) ,next() → O(1) , hasNext() → O(1) and space complexity O(n)(stores all ndoes).

package Binary_Search_Tree;
import java.util.*;

/*class BSTIterator {
    
    List<Integer> list = new ArrayList<>();
    int index = 0;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    private void inorder(TreeNode node){
        if(node == null) return ;

        inorder(node.left);
        list.add(node.val);
        inorder(node.right);

    }
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}*/

//Optimal solution with time complexity of Constructor → O(h) (only pushing left nodes), next() → O(1) , hasNext() → O(1) and space complexity of 0(h) (height of tree).
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }

    private void pushAllLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();

        if(curr.right != null){
            pushAllLeft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}