class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() <= k - 1)
            return s;

        Stack<Pair<Character, Integer>> stack = new Stack<>();
        stack.push(new Pair<Character, Integer>(s.charAt(0), 1));
        // {(a, 2)}
        for (int index = 1; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!stack.isEmpty() && ch == stack.peek().getKey()) {
                Pair<Character, Integer> p = stack.pop();
                if (p.getValue() == k - 1) {
                    continue;
                } else {
                    stack.push(new Pair<Character, Integer>(p.getKey(), p.getValue() + 1));
                }
            } else {
                stack.push(new Pair<Character, Integer>(s.charAt(index), 1));
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> p = stack.pop();
            int count = p.getValue();
            char ch = p.getKey();
            while (count > 0) {
                sb.insert(0, ch);
                count--;
            }
        }

        return sb.toString();

    }
}