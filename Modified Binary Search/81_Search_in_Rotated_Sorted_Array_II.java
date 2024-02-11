class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid;
        // nums = [1,0,1,1,1], target = 0
        // left =0, right=2
        // mid=1
        while (left <= right) {

            // shifting to remove duplicate elements
            while (left < right && nums[left] == nums[left + 1])
                left += 1;
            while (left < right && nums[right] == nums[right - 1])
                right -= 1;

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return false;

    }
}