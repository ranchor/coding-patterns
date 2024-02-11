class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1)
            return s;

        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqCounter.put(ch, freqCounter.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<Pair<Character, Integer>>(
                (a, b) -> (Integer.compare(b.getValue(), a.getValue())));

        freqCounter.forEach((k, v) -> {
            maxHeap.offer(new Pair(k, v));
        });

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 0) {
            Pair<Character, Integer> p = maxHeap.poll();
            int count = p.getValue();
            char key = p.getKey();
            while (count != 0) {
                sb.append(key);
                count--;
            }
        }

        return sb.toString();

    }
}