package Binary_Search;

class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;

        int floor = -1;
        int ceil = -1;

        int low = 0, high = n - 1;

        // Find Floor
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];   // possible answer
                low = mid + 1;       // go right
            } else {
                high = mid - 1;
            }
        }

        // Reset pointers for Ceil
        low = 0;
        high = n - 1;

        // Find Ceil
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];    // possible answer
                high = mid - 1;      // go left
            } else {
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }
}