//problem link : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
//problem name : Two Sum IV - Input is a BST

//brute force solution with time complexity of O(n) and space complexity of O(n).

package Binary_Search_Tree;
import java.util.*;

class Solution {

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
}
