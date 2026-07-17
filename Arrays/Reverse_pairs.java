package Arrays;

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = 0;
        count += mergeSort(nums, low, mid);        // left half
        count += mergeSort(nums, mid + 1, high);   // right half
        count += countPairs(nums, low, mid, high); // count cross pairs

        merge(nums, low, mid, high);               // merge step

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right<=high && (long)nums[i] > 2*(long)nums[right]){
                right++;
            }
            count = count + (right-(mid+1));
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}



//brute force
 /*int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((long) nums[i] > 2*(long)nums[j]){
                    count++;
                }
            }
        }
        return count; */