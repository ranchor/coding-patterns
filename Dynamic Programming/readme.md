# Introduction
* It is an algorithmic paradigm that solves a given complex problem by breaking it into subproblems and storing the 
results of subproblems to avoid computing the same results again.
* Utilizes the fact that the optimal solution to the overall problem depends on the optimal solutions to its subproblems.
* Example: **Fibonacci numbers** - We can calculate nth Fibonacci by below equation
```
Fib(n) = Fib(n-1) + Fib(n-2) for n >1
```

## Characteristics of Dynamic Programming
### Overlapping Subproblems
* Subproblems are smaller versions of the original problem. 
* Any problem has overlapping sub-problems if finding its solution involves solving the same subproblem multiple times. 
* In dynamic programming, computed solutions to subproblems are stored in a table so that these don’t have to be recomputed
* **Binary Search** is broken down into subproblems but it doesn’t have common subproblems, so no sense to store the solutions
* Take the example of the Fibonacci numbers; to find the ``fib(4)``, we need to break it down into the following sub-problems:

![](https://astikanand.github.io/techblogs/dynamic-programming-patterns/assets/fibonacci_subproblems.png)

### Optimal Substructure Property
* Any problem has optimal substructure property if its overall optimal solution can be constructed from the 
optimal solutions of its subproblems. 
* For Fibonacci numbers, as we know,
```
Fib(n) = Fib(n-1) + Fib(n-2)
```
This clearly shows that a problem of size ‘n’ has been reduced to subproblems of size ‘n-1’ and ‘n-2’. Therefore, 
Fibonacci numbers have optimal substructure property

## Dynamic Programming Methods
DP offers two methods to solve a problem.

### Recursion + Memoization(Top-down Approach)
* In this approach, we try to solve the bigger problem by recursively finding the solution to smaller sub-problems. 
* Whenever we solve a sub-problem, we cache its result so that we don’t end up solving it repeatedly if it’s called 
multiple times. Instead, we can just return the saved result. 
* This technique of storing the results of already solved subproblems is called **Memoization**.

### Iteration + Tabulation (Bottom-up Approach)
* Tabulation is the opposite of the top-down approach and avoids recursion. 
* In this approach, we solve the problem “bottom-up” (i.e. by solving all the related sub-problems first). 
* This is typically done by filling up an n-dimensional table. 
* Based on the results in the table, the solution to the top/original problem is then computed.

* Tabulation is the opposite of Memoization, as in Memoization we solve the problem and maintain a map of already 
solved sub-problems. In other words, in memoization, we do it top-down in the sense that we solve the top problem 
first (which typically recurse down to solve the sub-problems).

## Pattern 1: Fibonacci Numbers
1. [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
1. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
1. [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)
1. [Number divisors](https://www.geeksforgeeks.org/total-number-divisors-given-number/)
1. [Jump Game](https://leetcode.com/problems/jump-game/)
1. [Jump Game II](https://leetcode.com/problems/jump-game-ii/)
1. [House Robber](https://leetcode.com/problems/house-robber/)
1. [House Robber II](https://leetcode.com/problems/house-robber-ii/)

## Pattern 2: Kadane's Algorithm
1. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
1. [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
1. [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)

## Pattern 3: 0/1 Knapsack
1. [0/1 Knapsack Problem](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
1. [Subset Sum](https://www.geeksforgeeks.org/subset-sum-problem-dp-25/)
1. [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
1. [Minimum Subset Sum Difference](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/)
1. [Count of subset sum](https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/)
1. [Target Sum](https://leetcode.com/problems/target-sum/)
1. [Last Stone Weight](https://leetcode.com/problems/last-stone-weight-ii/)

### Top-Down
```java
 // Function to solve the 0/1 Knapsack problem using top-down dynamic programming
    static int knapsack(int[] weights, int[] values, int w, int n, int[][] dp) {
        // Base case: If either w or number of items is 0, return 0
        if (n == 0 || w == 0)
            return 0;

        // If the result is already calculated, return it
        if (dp[n][w] != -1)
            return dp[n][w];

        // If the weight of the current item exceeds the capacity, skip it
        if (weights[n - 1] > w)
            return dp[n][w] = knapsack(weights, values, w, n - 1, dp);

        // Otherwise, return the maximum of including and excluding the current item
        else
            return dp[n][w] = Math.max(values[n - 1] + knapsack(weights, values, w - weights[n - 1], n - 1, dp), knapsack(weights, values, w, n - 1, dp));
    }

    // Function to initialize the DP array and call the recursive function
    static int knapsack(int[] weights, int[] values, int w) {
        int n = weights.length;
        // Create DP array and initialize it with -1
        int[][] dp = new int[n + 1][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Call the recursive function
        return knapsack(weights, values, w, n, dp);
    }
```
### Bottom-Up
```java
 // Function to solve the 0/1 Knapsack problem using bottom-up dynamic programming
    static int knapsack(int[] weights, int[] values, int w) {
        int n = weights.length;
        // Create DP array
        int[][] dp = new int[n + 1][w + 1];

        // Build DP table in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: If either no items or no capacity, value is 0
                } else if (weights[i - 1] <= j) {
                    // If weight of current item is less than or equal to current capacity,
                    // choose the maximum of including and excluding the item
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    // If weight of current item is greater than current capacity, exclude the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w]; // Return the maximum value that can be obtained
    }
```

### Notes
* Identify the dimensions of memo or tab array - Generally varying inputs in recursive function
* Identify the initialization conditions
* Identify the decision tree

## Pattern 4: Unbounded Knapsack
1. [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
1. [Coin Change](https://leetcode.com/problems/coin-change/)
1. [Coin Change II](https://leetcode.com/problems/coin-change-2/)
1. [Integer Break](https://leetcode.com/problems/integer-break/)
1. [Rod Cutting](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)
1. [Maximum Ribbon Cut](https://www.geeksforgeeks.org/maximum-number-segments-lengths-b-c/)
1. [Minimum Cost for Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)


## Pattern 5: Longest Increasing Subsequence (LIS)
1. [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
1. [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
1. [Maximum Sum Increasing Subsequence](https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/)
1. [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/)
1. [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)
1. [Minimum Number of Removals to Make Mountain Array](https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/)
**Bottom-Up**
```java
  public int lengthOfLIS(int[] nums) {
        // Create an array to store the length of the longest increasing subsequence ending at each index
        int[] dp = new int[nums.length];
        // Initialize the array with 1, as each element is a subsequence of length 1
        Arrays.fill(dp, 1);
        
        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // For each element at index i, iterate through elements before it
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the element at index j,
                // update the length of the LIS ending at index i
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update the length of LIS ending at index i
                }
            }
        }
        
        int longest = 0;
        // Find the maximum value in the dp array, which represents the longest increasing subsequence length
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest; // Return the length of the longest increasing subsequence
    }
```

## Pattern 6: Longest Common Subsequence (LCS)
1. [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
1. [Longest Common Substring](https://www.geeksforgeeks.org/longest-common-substring-dp-29/)
1. [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
1. [Longest repeating subsequence](https://www.geeksforgeeks.org/longest-repeating-subsequence/)
1. [Minimum Deletions and Insertions to Transform a String into another](https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/)
1. [Minimum deletions to make sequence sorted](https://www.geeksforgeeks.org/minimum-number-deletions-make-sorted-sequence/)
1. [Longest Alternating Subsequence](https://www.geeksforgeeks.org/longest-alternating-subsequence/)
1. [Edit Distance](https://leetcode.com/problems/edit-distance//)
1. [String Interleaving](https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/)


**Top-Down**
```java
    // Function to calculate Longest Common Subsequence
    static int lcs(String a, String b, int m, int n, int[][] dp) {
        // Base case
        if (m == 0 || n == 0) return 0;

        // Check if the result is already calculated
        if (dp[m][n] != -1) return dp[m][n];

        // If characters match, include them in the LCS
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp[m][n] = 1 + lcs(a, b, m - 1, n - 1, dp);
        else
            // If characters don't match, choose the maximum length LCS from the two possible cases
            return dp[m][n] = Math.max(lcs(a, b, m - 1, n, dp), lcs(a, b, m, n - 1, dp));
    }
     public static void main(String[] args) {
        static final int MAX_M = 1005;
        static final int MAX_N = 1005;
        int[][] dp = new int[MAX_M][MAX_N];
        // Initialize dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        lcs(a, b, m, n, dp);
    }
```
**Bottom-up**
```java
  static int lcs(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
```

## Pattern 7: Palindromes
1. [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
1. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
1. [Count of Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
1. [Minimum insertions to make a string palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
1. [Minimum deletions to make a string palindrome](https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/)
1. [Palindromic Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

```java
 // Function to find the length of the Longest Palindromic Subsequence (LPS) from index 'start' to 'end'
    static int lps(String s, int start, int end, int[][] dp) {
        // Base case: If start index is greater than end index, return 0
        if (start > end)
            return 0;

        // Base case: If start index is equal to end index, LPS length is 1
        if (start == end)
            return 1;

        // If the result for the current state is already calculated, return it
        if (dp[start][end] != 0)
            return dp[start][end];

        // If characters at start and end index are equal, increment LPS length by 2
        if (s.charAt(start) == s.charAt(end))
            return dp[start][end] = 2 + lps(s, start + 1, end - 1, dp);

        // If characters are not equal, find the maximum LPS length by excluding either the start or end character
        return dp[start][end] = Math.max(lps(s, start + 1, end, dp), lps(s, start, end - 1, dp));
    }

    // Function to find the length of the Longest Palindromic Subsequence (LPS) in the string 's'
    static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        // Initialize DP array with 0s
        int[][] dp = new int[n][n];
        // Call the recursive function to find the length of LPS from index 0 to 'n-1'
        return lps(s, 0, n - 1, dp);
    }

```
## Pattern 8: Matrix Chain Multiplication (MCM)
1. [Burst Balloons](https://leetcode.com/problems/burst-balloons/)
1. Evaluate expression to true / boolean parenthesize
1. Minimum or maximum value of a expression
1. Palindrome partitioning
1. [Super Egg Drop](https://leetcode.com/problems/super-egg-drop/)


## Pattern 9: DP on 2D Grids
1. [Unique Paths](https://leetcode.com/discuss/study-guide/1437879/dynamic-programming-patterns)
1. [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
1. [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
1. [Dungeon Game](https://leetcode.com/problems/dungeon-game/)
1. [Cherry Pickup](https://leetcode.com/problems/cherry-pickup/)

## Pattern 10: DP on Trees
1. [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
1. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
1. [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)
1. [House Robber III](https://leetcode.com/problems/house-robber-iii/)

## Pattern 11: DP + Bitmask
1. [Maximum Students Taking Exam](https://leetcode.com/problems/maximum-students-taking-exam/)


# Problems

## Fibonacci Number



# References
* https://leetcode.com/discuss/study-guide/1437879/dynamic-programming-patterns
* https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews
* https://leetcode.com/discuss/general-discussion/458695/Dynamic-Programming-Patterns
    * https://www.youtube.com/watch?v=wHzI0NCpjpI&t=127s   
    * https://www.youtube.com/watch?v=mBNrRy2_hVs
* https://leetcode.com/discuss/study-guide/1308617/Dynamic-Programming-Patterns
* https://leetcode.com/discuss/general-discussion/662866/DP-for-Beginners-Problems-or-Patterns-or-Sample-Solutions
* https://leetcode.com/discuss/explore/april-leetcoding-challenge-2021/1159786/fibonacci-number-easy-solution-w-multiple-approaches-explained
* [Difference between Subarray, SubString, Subsequence and Subset](https://www.techiedelight.com/difference-between-subarray-subsequence-subset/)
* [Aditya's Verma DP Playlist](https://www.youtube.com/playlist?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go)