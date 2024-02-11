class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> lookup = new HashMap<>();
        stack.push(nums2[0]);
        for (int index = 1; index < nums2.length; index++) {

            while (!stack.isEmpty() && stack.peek() < nums2[index]) {
                lookup.put(stack.pop(), nums2[index]);
            }
            stack.push(nums2[index]);

        }

        while (!stack.isEmpty()) {
            lookup.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int index = 0; index < nums1.length; index++) {
            res[index] = lookup.get(nums1[index]);
        }

        return res;

    }
}