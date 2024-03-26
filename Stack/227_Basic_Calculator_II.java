class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        boolean isOperator = false;
        int number = 0, value, index = 0;
        char operator = ' ';

        // 3+2*2
        // ch=
        // index=5
        // ptr=5
        // number =2
        // stack=[3, 4]
        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isWhitespace(ch)) {
                index++;
                continue;
            } else if (Character.isDigit(ch)) {
                int ptr = index;
                while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
                    number = number * 10 + (s.charAt(ptr) - '0');
                    ptr++;
                }

                index = ptr;
                value = number;
                number = 0;
                if (isOperator) {
                    if (operator == '*') {
                        value = stack.pop() * value;
                    } else if (operator == '/') {
                        value = stack.pop() / value;
                    } else if (operator == '-') {
                        value = -value;
                    }
                    isOperator = !isOperator;
                }

                stack.push(value);

            } else if (isOperator(ch)) {
                operator = ch;
                isOperator = true;
                index++;
            }

        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;

    }

    boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }
}