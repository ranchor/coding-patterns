class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // Instead of digits check, check whether current token is not operator and then
            // push it into stack
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int output = operation(a, b, token);
                stack.push(output);
            }
        }

        return stack.pop();
    }

    boolean isOperator(String temp) {
        return (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"));
    }

    int operation(int a, int b, String temp) {
        if (temp.equals("+")) {
            return a + b;
        } else if (temp.equals("*")) {
            return a * b;
        } else if (temp.equals("/")) {
            return b / a;
        } else if (temp.equals("-")) {
            return b - a;
        }
        return 0;
    }

}