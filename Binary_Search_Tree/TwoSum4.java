//problem link : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
//problem name : Two Sum IV - Input is a BST

//brute force solution with time complexity of O(n)(visit every node once) and space complexity of O(n)(hashset).

package Binary_Search_Tree;
import java.util.*;

/*class Solution {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return check(root, k, set);
    }

    public boolean check(TreeNode node, int k, HashSet<Integer> set) {

        // base case
        if (node == null) return false;

        // step 1: check if pair exists
        if (set.contains(k - node.val)) return true;

        // step 2: store current value
        set.add(node.val);

        // step 3: go left OR right
        return check(node.left, k, set) || check(node.right, k, set);
    }
}*/

//Optimal solution with time complexity of O(n) and space complexity of O(h)(height of tree).
//BSTiterator
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();

        if (reverse) pushAll(node.left);
        else pushAll(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse) node = node.right;
            else node = node.left;
        }
    }
}

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) return false;

        BSTIterator left = new BSTIterator(root, false);   // smallest
        BSTIterator right = new BSTIterator(root, true);   // largest

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = left.next();
            else j = right.next();
        }

        return false;
    }
}
