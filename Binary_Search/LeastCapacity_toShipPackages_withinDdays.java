/*| Approach          | Time Complexity               | Space Complexity |
 
 **Brute Force**       `O((sum - maxWeight) × n)`      `O(1)`           
 **Binary Search**     `O(n × log(sum - maxWeight))`   `O(1)`           */



//brute force 
/*
class Solution {

    private boolean canShip(int[] weights, int days , int capacity){
        int requiredDays = 1;
        int currentLoad = 0;

        for(int i=0; i<weights.length; i++){
            if(currentLoad + weights[i] > capacity){
            requiredDays++;
            currentLoad = 0;
            }
            currentLoad += weights[i];
        }
        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int i=0; i<weights.length; i++){
            low = Math.max(low,weights[i]);
            high += weights[i];
      }

      for(int capacity = low ; capacity<=high; capacity++){
        if(canShip(weights, days, capacity)){
            return capacity;
        }
      }
      return -1;
    }
} */


//optimal solution

package Binary_Search;

class Solution {

    private boolean canShip(int[] weights, int days, int capacity){
        int requiredDays = 1;
        int currentLoad = 0;

        for(int i=0; i<weights.length; i++){
            if(currentLoad + weights[i] > capacity){
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weights[i];
        }
        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int i =0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int answer = high;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(canShip(weights, days, mid)){
                answer = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return answer;
  }
}