package Binary_Search;

//brute force

/*class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int maxDist = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        for (int d = 1; d <= maxDist; d++) {
            if (canPlace(stalls, k, d)) {
                ans = d;   // update answer
            }
        }

        return ans;
    }

    private boolean canPlace(int[] stalls, int k, int dist) {
        int count = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }

            if (count >= k) return true;
        }

        return false;
    }
}*/

//optimal solution

import java.util.*;

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, k, mid)) {
                ans = mid;        // possible answer
                low = mid + 1;    // try for bigger distance
            } else {
                high = mid - 1;   // reduce distance
            }
        }

        return ans;
    }

    private boolean canPlace(int[] stalls, int k, int dist) {
        int count = 1;  // first cow placed
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }

            if (count >= k) return true;
        }

        return false;
    }
}