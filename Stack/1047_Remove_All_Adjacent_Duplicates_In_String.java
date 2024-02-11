class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() <= 1)
            return s;

        Stack<Character> stack = new Stack<>();
        for (char curr : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != curr) {
                stack.push(curr);
            } else {
                stack.pop();
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}