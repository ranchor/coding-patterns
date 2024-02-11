class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair(0, nums[0]));

        // nums = [1,2,1]
        // stack= [(1, 2)]
        // res = [2,-1, 2]
        for (int index = 1; index < nums.length; index++) {
            while (!stack.isEmpty() && stack.peek().getValue() < nums[index]) {
                res[stack.pop().getKey()] = nums[index];
            }
            stack.push(new Pair(index, nums[index]));
        }

        for (int index = 0; index < nums.length; index++) {
            while (!stack.isEmpty() && stack.peek().getValue() < nums[index]) {
                res[stack.pop().getKey()] = nums[index];
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop().getKey()] = -1;
        }
        return res;
    }
}