//brute force with time and space complexity of O(n+m).

//better solution with no extra space (time complexity O(n+m) and space complexity O(1))

//optimal solution (time complexity O(log(min(n, m))) and space complexity O(1) )


//brute force 
/*
 int n = nums1.length , m = nums2.length;
        int[] arr3 = new int[n+m];

        int i=0, j=0, k=0;

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                arr3[k++] = nums1[i++];
            }
            else {
                arr3[k++] = nums2[j++];
            }
        }

        while(i<n) arr3[k++]=nums1[i++];
        while(j<m) arr3[k++]=nums2[j++];
        int total = n+m;

        if(total%2==1){
            return arr3[total/2];
        }
        else {
            return (arr3[total/2-1]+arr3[total/2])/2.0;
        }
*/

//better solution with no extra space
/*
int n = nums1.length , m = nums2.length;
        int total = n+m;

        int i=0, j=0;
        int count = 0;

        int prev=0;
        int curr=0;

        while(count<=total/2){
            prev=curr;
            if(i<n && (j>=m || nums1[i] < nums2[j])){
                curr = nums1[i++];
            }
            else {
                curr = nums2[j++];
            }
            count++;
        }

        if(total%2==1){
            return curr;
        }
        else {
             return (prev+curr)/2.0;
        }
*/


//optimal solution 
package Binary_Search;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n1=nums1.length;
        int n2=nums2.length;

        int low=0, high=n1;

        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            int l1 = (mid1==0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = (mid2==0) ? Integer.MIN_VALUE : nums2[mid2-1];

            int r1 = (mid1==n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2==n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 1){
                    return Math.max(l1,l2);
                }

                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }

            else if(l1 > r2){
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}
