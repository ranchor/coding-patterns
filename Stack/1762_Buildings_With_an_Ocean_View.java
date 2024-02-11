class Solution {
    public int[] findBuildings(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int index = 1; index < heights.length; index++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[index]) {
                stack.pop();
            }

            stack.push(index);
        }

        int size = stack.size();
        int[] arr = new int[size];
        size = size - 1;
        while (!stack.isEmpty()) {
            arr[size--] = stack.pop();
        }

        return arr;
    }
}