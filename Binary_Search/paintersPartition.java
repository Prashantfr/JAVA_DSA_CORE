//time complexity
/*Binary Search → O(log(sum of boards))
Each check → O(N)

Total → O(N * log(sum))*/

package Binary_Search;

class Solution {

    public int paint(int A, int B, int[] C) {

        // -------------------------------
        // Step 1: Define search space
        // low = max board length (minimum possible max work)
        // high = sum of all boards (maximum possible work)
        // -------------------------------
        long low = 0;
        long high = 0;

        for (int length : C) {
            low = Math.max(low, length); // at least one board must be painted
            high += length;              // one painter paints everything
        }

        long ans = high;

        // -------------------------------
        // Step 2: Binary Search on Answer
        // Time Complexity: O(log(sum))
        // -------------------------------
        while (low <= high) {

            long mid = low + (high - low) / 2;
            // Assume: max work allowed per painter = mid

            // -------------------------------
            // Step 3: Check feasibility
            // Time Complexity: O(N)
            // -------------------------------
            if (canPaint(C, A, mid)) {

                // If possible, store answer and try smaller value
                ans = mid;
                high = mid - 1;

            } else {

                // If not possible, increase allowed work
                low = mid + 1;
            }
        }

        // -------------------------------
        // Step 4: Multiply by B (time per unit)
        // Take modulo as per problem
        // -------------------------------
        return (int)((ans * B) % 10000003);
    }

    // ---------------------------------------------------------
    // Helper Function: Check if we can paint with given maxWork
    // ---------------------------------------------------------
    private boolean canPaint(int[] boards, int painters, long maxWork) {

        int count = 1;          // start with 1 painter
        long currentWork = 0;   // work assigned to current painter

        // Traverse all boards
        for (int length : boards) {

            // If current painter can take this board
            if (currentWork + length <= maxWork) {
                currentWork += length;
            } 
            else {
                // Assign new painter
                count++;
                currentWork = length;
            }
        }

        // If painters needed <= available painters → possible
        return count <= painters;
    }
}