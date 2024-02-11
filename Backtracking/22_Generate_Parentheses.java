class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        backtrack(n, new StringBuilder(), 0, 0, output);
        return output;
    }

    // n =3
    // openCounts = 3
    // closedCounts = 2
    // output = ["((()))", "(()())"]
    // sb = "(()())"

    void backtrack(int n, StringBuilder sb, int openCounts, int closedCounts, List<String> output) {
        if (sb.length() == 2 * n) {
            output.add(sb.toString());
            return;
        }

        if (openCounts < n) {
            sb.append("(");
            backtrack(n, sb, openCounts + 1, closedCounts, output);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (openCounts > closedCounts) {
            sb.append(")");
            backtrack(n, sb, openCounts, closedCounts + 1, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}