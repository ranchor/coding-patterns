class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(new Pair(0, temperatures[0]));
        for (int index = 1; index < temperatures.length; index++) {
            while (!stack.isEmpty() && stack.peek().getValue() < temperatures[index]) {
                Pair<Integer, Integer> p = stack.pop();
                res[p.getKey()] = index - p.getKey();
            }
            stack.push(new Pair(index, temperatures[index]));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> p = stack.pop();
            res[p.getKey()] = 0;
        }
        return res;
    }
}