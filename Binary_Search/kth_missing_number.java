//brute force
/*
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int num = 1;
        int count = 0;

        while(true){
            if(i<arr.length && arr[i]==num){
                i++;
            }
            else{
                count++;
                if(count==k){
                    return num;
                }
            }
            num++;
        }
    }
}
*/
//optimal solution

package Binary_Search;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int missing = arr[mid] - (mid+1);

            if(missing<k){
                low = mid + 1;
            }
            else {
                high = mid-1;
            }
        }
        return low+k;
    }
}