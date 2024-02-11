class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length<=1) return new int[0];

        int left=0, right=numbers.length-1;
        int[] ans = new int[2];

        while(left<right) {
            if(numbers[left]+numbers[right]==target) {
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            } else if(numbers[left]+numbers[right]<target) {
                left++;
            } else {
                right--;
            }

        }

        return new int[0];
    }
}