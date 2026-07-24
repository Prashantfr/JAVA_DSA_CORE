//brute force 
//ceil = (num+mid-1)/mid //this formula will return the ceil value
/*
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        for(int d=1; d<=max; d++){
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                sum += (nums[i] + d - 1) / d ;  //this is the main concept (ceil)
            }

            if(sum<=threshold){
                return d;
            }
        }
        return -1;
    }
} */

//optimal

package Binary_Search;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        // find max element (upper bound)
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int sum = 0;
            for (int num : nums) {
                // ceil(num / mid)
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                high = mid;      // try smaller divisor
            } else {
                low = mid + 1;   // increase divisor
            }
        }

        return low;
    }
}

