class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // s = "23+2*2"
        // prevOperator = *
        // stack = [3,2]
        // ch =3

        int number = 0;
        char prevOperator = '+';
        Stack<Integer> stack = new Stack();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            if (isOperator(ch) || index == (s.length() - 1)) {
                evaluate(prevOperator, number, stack);
                prevOperator = ch;
                number = 0;
            }
        }

        // with second else if we don't need ths outside.
        // evaluate(prevOperator, number, stack);

        int output = 0;
        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }

    boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    void evaluate(char operator, int number, Stack<Integer> stack) {
        if (operator == '+') {
            stack.push(number);
        } else if (operator == '-') {
            stack.push(-number);
        } else if (operator == '*') {
            stack.push(stack.pop() * number);
        } else if (operator == '/') {
            stack.push(stack.pop() / number);
        }
    }
}