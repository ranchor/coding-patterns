class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null)
            return 0;

        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lcs(text1, text2, text1.length(), text2.length(), memo);

    }

    int lcs(String text1, String text2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] != -1)
            return memo[m][n];

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcs(text1, text2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = Math.max(lcs(text1, text2, m - 1, n, memo), lcs(text1, text2, m, n - 1, memo));
        }

    }
}