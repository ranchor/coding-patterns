class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> lookup = new HashMap<>();
        int maxLength = 0;

        int windowLeft = 0, windowRight = 0;

        while (windowRight < s.length()) {
            char tempRight = s.charAt(windowRight);
            lookup.put(tempRight, lookup.getOrDefault(tempRight, 0) + 1);
            windowRight++;

            while (lookup.get(tempRight) > 1) {
                char tempLeft = s.charAt(windowLeft);
                if (lookup.get(tempLeft) == 0) {
                    lookup.remove(tempLeft);
                } else {
                    lookup.put(tempLeft, lookup.get(tempLeft) - 1);
                }

                windowLeft++;
            }


            maxLength = Math.max(maxLength, windowRight - windowLeft);
        }

        return maxLength;

    }
}