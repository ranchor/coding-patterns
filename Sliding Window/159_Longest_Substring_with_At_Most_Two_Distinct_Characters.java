class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        int windowLeft = 0, windowRight = 0;
        int maxLength = 0;
        Map<Character, Integer> lookup = new HashMap<>();

        while (windowRight < s.length()) {
            char rightValue = s.charAt(windowRight);
            lookup.put(rightValue, lookup.getOrDefault(rightValue, 0) + 1);
            windowRight++;

            while (lookup.size() > 2) {
                char leftValue = s.charAt(windowLeft);
                int count = lookup.get(leftValue);
                if (count == 1) {
                    lookup.remove(leftValue);
                } else {
                    lookup.put(leftValue, count - 1);
                }
                windowLeft++;
            }


            maxLength = Math.max(maxLength, windowRight - windowLeft);
        }

        return maxLength;

    }
}