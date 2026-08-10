//problem name : Reverse Words in a String
//problem link : https://leetcode.com/problems/reverse-words-in-a-string/description/

//brute force solution with time complexity of O(n) and space complexity O(N)(extra array + string).

package Strings;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder results = new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            if(!words[i].isEmpty()){
                results.append(words[i]).append(" ");
            }
        }
        return results.toString().trim();
    }
}
