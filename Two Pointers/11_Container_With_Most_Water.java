class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            }

        }

        return maxArea;
    }
}