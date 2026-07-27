//this is the problem for min of maxs
//brute force i.e. linear seach where we will check each iteration
/*
class Solution {

    public int allocateBooks(int[] pages, int m) {
        int n = pages.length;

        if (m > n) return -1;

        int max = 0, sum = 0;

        for (int page : pages) {
            max = Math.max(max, page);
            sum += page;
        }

        // try every possible answer
        for (int i = max; i <= sum; i++) {
            if (isPossible(pages, m, i)) {
                return i; // first valid is minimum
            }
        }

        return -1;
    }

    private boolean isPossible(int[] pages, int m, int maxPages) {
        int students = 1;
        int current = 0;

        for (int page : pages) {
            if (current + page <= maxPages) {
                current += page;
            } else {
                students++;
                current = page;

                if (students > m) return false;
            }
        }

        return true;
    }
} */

//optimal solution


package Binary_Search;

class Solution {

    public int allocateBooks(int[] pages, int m) {
        int n = pages.length;

        if (m > n) return -1;

        int low = 0, high = 0;

        // find max and sum
        for (int page : pages) {
            low = Math.max(low, page); // max
            high += page;              // sum
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(pages, m, mid)) {
                ans = mid;
                high = mid - 1; // try smaller answer
            } else {
                low = mid + 1;  // increase limit
            }
        }

        return ans;
    }

    private boolean isPossible(int[] pages, int m, int maxPages) {
        int students = 1;
        int current = 0;

        for (int page : pages) {
            if (current + page <= maxPages) {
                current += page;
            } else {
                students++;
                current = page;

                if (students > m) return false;
            }
        }

        return true;
    }
}
