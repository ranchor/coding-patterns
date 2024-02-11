class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0)
            return Collections.emptyList();

        HashMap<String, Integer> freqCounter = new HashMap<>();
        for (String word : words) {
            freqCounter.put(word, freqCounter.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<Pair<String, Integer>>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey().compareTo(a.getKey());
            } else {
                return a.getValue() - b.getValue();
            }
        });

        freqCounter.forEach((key, value) -> {
            pq.offer(new Pair(key, value));
            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<String> output = new ArrayList<>();
        while (pq.size() > 0) {
            Pair<String, Integer> p = pq.poll();
            output.add(0, p.getKey());
        }

        return output;

    }
}