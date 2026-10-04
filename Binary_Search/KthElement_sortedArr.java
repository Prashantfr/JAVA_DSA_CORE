//brute force with the time and space complexity of O(n+m)
/*
class Solution {
    public int kthElement(int[] nums1, int[] nums2, int k) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Create merged array
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, idx = 0;

        // Merge both arrays
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged[idx++] = nums1[i++];
            } else {
                merged[idx++] = nums2[j++];
            }
        }

        // Remaining elements
        while (i < n1) {
            merged[idx++] = nums1[i++];
        }

        while (j < n2) {
            merged[idx++] = nums2[j++];
        }

        // Return k-th element (1-based index)
        return merged[k - 1];
    }
}
*/

//optimal solution with the time complexity of O(log(min(n, m))) and space complexity O(1)
package Binary_Search;

class Solution {
    public int kthElement(int[] nums1, int[] nums2, int k) {

        // Always binary search on smaller array
        if (nums1.length > nums2.length) {
            return kthElement(nums2, nums1, k);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Important range
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            // Edge handling
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            // Move left
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // Move right
            else {
                low = mid1 + 1;
            }
        }

        return -1; // should never happen
    }
}
