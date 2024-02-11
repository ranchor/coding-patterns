class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        if (s == null || s.length() == 0) return output;
        backtrack(new StringBuilder(), 0, s, output);
        return output;
    }


    void backtrack(StringBuilder sb, int currWordIndex, String s, List<String> output) {

        if (currWordIndex >= s.length()) {
            output.add(sb.toString());
            return;
        }

        if (s.charAt(currWordIndex) >= '0' && s.charAt(currWordIndex) <= '9') {
            sb.append(s.charAt(currWordIndex));
            backtrack(sb, currWordIndex + 1, s, output);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(s.charAt(currWordIndex));
            backtrack(sb, currWordIndex + 1, s, output);
            sb.deleteCharAt(sb.length() - 1);
            if (s.charAt(currWordIndex) >= 'a' && s.charAt(currWordIndex) <= 'z') {
                sb.append(Character.toUpperCase(s.charAt(currWordIndex)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(currWordIndex)));
            }
            backtrack(sb, currWordIndex + 1, s, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}