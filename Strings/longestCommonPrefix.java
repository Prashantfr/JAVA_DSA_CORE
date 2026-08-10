//problem name : Longest Common Prefix
//problem link : https://leetcode.com/problems/longest-common-prefix/

//solution with time complexity of O(S)(sum of all characters in all strings ( worst case)) and space complexity O(1) (extra ignoring the output).
package Strings;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";

        String prefix = strs[0];
        
        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
