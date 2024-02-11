class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return output;

        Arrays.sort(nums);
        int left, right;
        // nums = [-1,0,1,2,-1,-4]
        // nums = [-4,-1,-1,0,1,2]
        // index=0, left=2, right=5
        for (int index = 0; index < nums.length - 2; index++) {
            // Skip Duplicates
            if (index != 0 && nums[index] == nums[index - 1])
                continue;

            left = index + 1;
            right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] + nums[index] == 0) {
                    List<Integer> result = new ArrayList();
                    result.add(nums[index]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    output.add(result);
                    left++;
                    right--;
                    // Skip Duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] + nums[index] < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return output;

    }
}