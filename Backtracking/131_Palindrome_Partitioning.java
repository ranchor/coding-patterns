class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return Collections.emptyList();

        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, output, new ArrayList<>());
        return output;
    }

    // aab
    // pos=2
    // i=1,
    // tempResult = [aa, b]
    // output = [[a, a, b], [aa, b]]
    // temp = a
    void backtrack(String s, int pos, List<List<String>> output, List<String> tempResult) {
        if (pos == s.length()) {
            output.add(new ArrayList(tempResult));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String temp = s.substring(pos, i + 1);
            if (!isPlaindrome(temp)) {
                continue;
            }
            tempResult.add(temp);
            backtrack(s, i + 1, output, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }

    boolean isPlaindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}