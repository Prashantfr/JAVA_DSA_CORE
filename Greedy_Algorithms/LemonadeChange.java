//problem link : https://leetcode.com/problems/lemonade-change/description/
//problem name : Lemonade Change

//Solution with time complexity of O(n) and space complexity is O(1).

package Greedy_Algorithms;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i=0 ; i<bills.length ; i++){
            if(bills[i] == 5){
                five++;
            }

            else if(bills[i] == 10){
                if(five == 0){
                    return false;
                }
                else{
                    five--;
                    ten++;
                }
            }

            else{
                if(ten != 0 && five !=0){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
