class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) {
            return -1;
        }
        int left=0, right=nums.length-1, mid;
        // nums = [-1,0,3,5,9,12], target = 2
        // left =0, right=5, mid=2
        while(left<=right) {
            mid = left+(right-left)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]<target) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }

        return -1;

    }
}