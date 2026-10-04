//problem name : Reverse Words in a String
//problem link : https://leetcode.com/problems/reverse-words-in-a-string/description/

//brute force solution with time complexity of O(n) and space complexity O(N)(extra array + string).

package Strings;

/*class Solution {
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
}*/

//optimal solution with time complexity => O(N) and space complexity => O(N)(output string only, no split array).
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;
            if(i<0) break;
            int j = i;

            while(i>=0 && s.charAt(i)!=' ') i--;
            result.append(s.substring(i+1, j+1)).append(' ');
        }
        return result.toString().trim();
    }
}