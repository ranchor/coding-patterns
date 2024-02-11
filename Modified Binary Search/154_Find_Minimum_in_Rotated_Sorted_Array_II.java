class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1, mid;

        while (left < right) {

            while(left<right && nums[left]==nums[left+1])
                left++;

            while(left<right && nums[right]==nums[right-1])
                right--;

            if(left==right) break;

            mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
        
    }
}