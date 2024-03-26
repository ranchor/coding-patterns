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
                // because we want to order them lexicographically (alphabetically) from higher
                // to lower in priority queue. so higher one can go out first.
                return b.getKey().compareTo(a.getKey());
            } else {
                return Integer.compare(a.getValue(), b.getValue());
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

    public List<String> topKFrequent_Approach2(String[] words, int k) {
        if (words == null || k == 0)
            return Collections.emptyList();

        HashMap<String, Integer> freqCounter = new HashMap<>();
        for (String word : words) {
            freqCounter.put(word, freqCounter.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(
                (a, b) -> freqCounter.get(a).equals(freqCounter.get(b)) ? b.compareTo(a)
                        : Integer.compare(freqCounter.get(a), freqCounter.get(b)));

        freqCounter.forEach((key, value) -> {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<String> output = new ArrayList<>();
        while (pq.size() > 0) {
            String value = pq.poll();
            output.add(0, value);
        }

        return output;

    }
}