class Solution {
    private static HashMap<Character, Character> mappings;

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || c != st.peek()) {
                return false;
            } else {
                st.pop();
            }
        }

        return st.isEmpty();
    }

    public boolean isValidUsingHashMap(String s) {

        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Empty string scenario
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        char curr;

        // if character is (, {,[ push in stack
        // if character is ), }, ] then check in mapping and see whether it exist in top
        // of the stack

        for (int index = 0; index < s.length(); index++) {
            curr = s.charAt(index);
            if (mappings.containsKey(curr)) {
                if (stack.empty() || stack.pop() != mappings.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();

    }
}