//problem link : https://leetcode.com/problems/asteroid-collision/description/
//problem name : Remove K Digits

//brute force solution (for conceptual only) with time complexity of O(2^n) and space complexity O(n).


package Stack_Queue;

/*class Solution {
    String min = null;

    public String removeKdigits(String num, int k) {
        solve(num, k, 0, new StringBuilder());
        return min == null ? "0" : min;
    }

    private void solve(String num, int k, int index, StringBuilder curr) {
        if (k < 0) return;

        if (index == num.length()) {
            if (k == 0) {
                String res = removeLeadingZero(curr.toString());
                if (min == null || res.compareTo(min) < 0) {
                    min = res;
                }
            }
            return;
        }

        // take
        curr.append(num.charAt(index));
        solve(num, k, index + 1, curr);
        curr.deleteCharAt(curr.length() - 1);

        // skip (remove this digit)
        solve(num, k - 1, index + 1, curr);
    }

    private String removeLeadingZero(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') i++;
        return i == s.length() ? "0" : s.substring(i);
    }
}*/
