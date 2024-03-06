class Solution {
    int longestCommonSubstr(String text1, String text2, int m, int n) {
        if (text1 == null || text2 == null)
            return 0;
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int maxLength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                maxLength = Math.max(maxLength, lcsTopDown(text1, text2, i, j, memo));
            }
        }
        return maxLength;

    }

    int lcsTopDown(String text1, String text2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] != -1)
            return memo[m][n];

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcsTopDown(text1, text2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = 0;
        }

    }
}