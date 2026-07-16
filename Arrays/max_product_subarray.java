package Arrays;

public class max_product_subarray {
    class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int tempMax = Math.max(num, Math.max(num * currMax, num * currMin));
            int tempMin = Math.min(num, Math.min(num * currMax, num * currMin));

            currMax = tempMax;
            currMin = tempMin;

            max = Math.max(max, currMax);
        }

        return max;
    }
}
}
