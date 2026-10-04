//problem name : Sum of Beauty of All Substrings
//problem link : https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

//solution with time complexity of O(n^2) and space complexity O(1).

package Strings;

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            int[] freq = new int[26];

            for(int j=i; j<n; j++){
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for(int k=0; k<26; k++){
                    if(freq[k]>0){
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                ans += (maxFreq - minFreq);
            }
        }
        return ans;
    }
}
