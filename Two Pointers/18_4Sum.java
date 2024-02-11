/*
Idea:
1. Reduce KSum to (K - 1)-Sum, then to (K - 2)-Sum until 2Sum.
2. Take care of oneSum separately.

Complexity - Time: O(n^(k - 1)), Space: O(k)
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < k || k <= 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        kSum(nums, 4, target, output, 0, new ArrayList<>());
        return output;
    }

    // use long for target.
    void kSum(int[] nums, int k, long target, List<List<Integer>> output, int start, List<Integer> tempResult) {
        // handle base case
        if(k==2) {
            int left = start;
            int right = nums.length-1;
            
            while(left<right) {
                long sum = nums[left]+nums[right];
                if(sum==target) {
                    List<Integer> newTemp = new ArrayList<>(tempResult);
                    newTemp.add(nums[left]);
                    newTemp.add(nums[right]);
                    output.add(newTemp);
                    left++;
                    right--;
                    // Skip duplicates
                    while(left<right && nums[left]==nums[left-1]) left++;
                    // Skip duplicates
                    while(left<right && nums[right]==nums[right+1]) right--;

                } else if(sum>target){
                    right--;
                } else {
                    left++;
                }
            }
            return;
        }

        // i < nums.length - k + 1, e.g., for 4Sum, i < nums.length - 3
        for(int i=start;i<=nums.length-k;i++) {
            // Skip duplicates
            if(i!=start && nums[i]==nums[i-1]) continue;
            tempResult.add(nums[i]);
            kSum(nums, k-1, target-nums[i], output, i+1, tempResult);
            tempResult.remove(tempResult.size()-1);
        }

    }
}