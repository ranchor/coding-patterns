class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n <= 1)
            return Collections.emptyList();
        List<List<Integer>> output = new ArrayList<>();
        backtrack(new ArrayList<>(), output, 2, n);
        return output;
    }

    void backtrack(List<Integer> factors, List<List<Integer>> output, int start, int target) {
        if (target == 1) {
            // to avoid adding solution of [n]
            if (factors.size() > 1)
                output.add(new ArrayList<>(factors));
            return;
        }
        for (int i = start; i <= target; i++) {
            if (target % i == 0) {
                factors.add(i);
                backtrack(factors, output, i, target / i);
                factors.remove(factors.size() - 1);
            }
        }
    }
}