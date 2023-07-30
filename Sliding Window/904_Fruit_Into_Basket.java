class Solution {
    public int totalFruit(int[] fruits) {

        if (fruits.length == 0) return 0;

        Map<Integer, Integer> lookup = new HashMap<>();
        int windowLeft = 0, windowRight = 0, maxFruits = 0;

        while (windowRight < fruits.length) {
            lookup.put(fruits[windowRight], lookup.getOrDefault(fruits[windowRight], 0) + 1);

            while (lookup.size() > 2) {
                if (lookup.get(fruits[windowLeft]) <= 1) {
                    lookup.remove(fruits[windowLeft]);
                } else {
                    lookup.put(fruits[windowLeft], lookup.get(fruits[windowLeft]) - 1);
                }
                windowLeft++;
            }
            windowRight++;
            maxFruits = Math.max(maxFruits, windowRight - windowLeft);
        }

        return maxFruits;
    }
}