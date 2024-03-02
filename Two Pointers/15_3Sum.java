class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return Collections.emptyList();
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        int left, right, target;
        // nums = [-1,0,1,2,-1,-4]
        // nums = [-4,-1,-1,0,1,2]
        // index=0, left=2, right=5
        for (int index = 0; index < nums.length - 2; index++) {
            // Skip Duplicates
            if (index != 0 && nums[index] == nums[index - 1])
                continue;

            left = index + 1;
            right = nums.length - 1;
            target = 0 - nums[index];
            while (left < right) {
                long sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> result = new ArrayList();
                    result.add(nums[index]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    output.add(result);
                    left++;
                    right--;
                    // Skip Duplicates
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return output;

    }
}