package Binary_Search;
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int firstZero = lowerBound(nums, 0); // first >= 0
        int firstPos = lowerBound(nums, 1);  // first >= 1

        int neg = firstZero;
        int pos = n - firstPos;

        return Math.max(pos, neg);
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}