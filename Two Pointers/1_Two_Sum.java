class Solution {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length <= 1)
            return new int[0];

        int[] ans = new int[2];

        HashMap<Integer, Integer> lookup = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (lookup.containsKey(nums[index])) {
                ans[0] = lookup.get(nums[index]);
                ans[1] = index;
                return ans;
            } else {
                lookup.put(target - nums[index], index);
            }
        }

        return new int[0];
    }
}