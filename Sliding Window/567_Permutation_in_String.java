class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;


        int windowLeft = 0, windowRight = 0;

        Map<Character, Integer> lookup = new HashMap<>();

        for (int index = 0; index < s1.length(); index++) {
            char temp = s1.charAt(index);
            lookup.put(temp, lookup.getOrDefault(temp, 0) + 1);
        }
        int counter = lookup.size();
        while (windowRight < s2.length()) {
            char tempRight = s2.charAt(windowRight);

            if (lookup.containsKey(tempRight)) {
                lookup.put(tempRight, lookup.get(tempRight) - 1);
                if (lookup.get(tempRight) == 0) counter--;
            }

            windowRight++;
            while (counter == 0) {
                char tempLeft = s2.charAt(windowLeft);
                if (lookup.containsKey(tempLeft)) {
                    lookup.put(tempLeft, lookup.get(tempLeft) + 1);
                    if (lookup.get(tempLeft) > 0) counter++;
                }
                if ((windowRight - windowLeft) == s1.length()) {
                    return true;
                }
                windowLeft++;
            }
        }
        return false;

    }
}