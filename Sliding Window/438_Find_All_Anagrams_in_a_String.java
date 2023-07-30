class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();

        if (p == null || s == null || p.length() > s.length()) return output;

        Map<Character, Integer> lookup = new HashMap<>();
        for (char ch : p.toCharArray()) {
            lookup.put(ch, lookup.getOrDefault(ch, 0) + 1);
        }
        int windowRight = 0, windowLeft = 0;
        int counter = lookup.size();

        while (windowRight < s.length()) {
            char tempRight = s.charAt(windowRight);
            if (lookup.containsKey(tempRight)) {
                lookup.put(tempRight, lookup.get(tempRight) - 1);
                if (lookup.get(tempRight) == 0) counter--;
            }

            windowRight++;

            while (counter == 0) {
                char tempLeft = s.charAt(windowLeft);
                if (lookup.containsKey(tempLeft)) {
                    lookup.put(tempLeft, lookup.get(tempLeft) + 1);
                    if (lookup.get(tempLeft) > 0) counter++;
                }

                if (windowRight - windowLeft == p.length()) {
                    output.add(windowLeft);
                }
                windowLeft++;
            }
        }
        return output;
    }
}