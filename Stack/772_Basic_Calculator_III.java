class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }

        return cal(queue);

    }

    // 4+(1+(4+5+2)-3)
    // q = [4, -, (, 1, +, (, 4, +, 5, +, 2, ), -, 3, )]
    // stack = [4, -9]
    // prevOperator = -
    // . stack = [1, 11, -3]
    // prevOperator=
    // stack = [4, 5, 2]
    //
    int cal(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char prevOperator = '+';
        int number = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '(') {
                number = cal(queue);
            } else if (isOperator(ch)) {
                evaluate(prevOperator, number, stack);
                prevOperator = ch;
                number = 0;
            } else if (ch == ')') {
                break;
            }

        }

        evaluate(prevOperator, number, stack);

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

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