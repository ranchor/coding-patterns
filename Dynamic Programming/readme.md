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
1. [Number divisors](https://www.geeksforgeeks.org/total-number-divisors-given-number/)

## Pattern 2: Minimum (Maximum) Path to Reach a Target
### Problem Statement
Given a target, find the minimum (or maximum) cost/path/sum to reach the target.

### Approach
- Choose the minimum (or maximum) path among all possible paths before the current state, then add the value for the current state.
- `routes[i] = min(routes[i-1], routes[i-2], ..., routes[i-k]) + cost[i]`

### Top-Down
 Recursively choose the minimum (or maximum) path among all possible paths before the current state and add the value for the current state. Memoize results to avoid recomputation.
```java
for (int j = 0; j < ways.size(); ++j) {
    result = min(result, topDown(target - ways[j]) + cost/ path / sum);
}
return memo[state_parameters] = result;
```

### Bottom-Up
Iteratively solve for all possible paths from the start to the target, updating the minimum (or maximum) cost/path/sum at each step.
```java
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] = min(dp[i], dp[i - ways[j]] + cost / path / sum);
       }
   }
}
return dp[target];
```
### Examples
1. [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)
2. [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
3. [Coin Change](https://leetcode.com/problems/coin-change/)
1. [Minimum Cost for Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)
1. [Jump Game II](https://leetcode.com/problems/jump-game-ii/)


## Pattern 3: Distinct Ways
### Problem Statement
Given a target, find the number of distinct ways to reach the target.

### Approach
- Sum all possible ways to reach the current state.
- `routes[i] = routes[i-1] + routes[i-2], ..., + routes[i-k]`

### Top-Down
```java
for (int j = 0; j < ways.size(); ++j) {
    result += topDown(target - ways[j]);
}
return memo[state_parameters] = result;
```

### Bottom-Up
```java
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] += dp[i - ways[j]];
       }
   }
}
return dp[target];
```

### Examples
1. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
1. [Unique Paths](https://leetcode.com/problems/unique-paths/)
1. [Unique Paths II](https://leetcode.com/problems/unique-paths/)
1. [Number of Dice Rolls With Target Sum](https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/)
1. [Knight Probability in Chessboard](https://leetcode.com/problems/knight-probability-in-chessboard/)
1. [Target Sum](https://leetcode.com/problems/target-sum/)


## Pattern 4 : Decision Making
### Problem Statement
Given a set of values, find an answer with an option to choose or ignore the current value.

### Approach
- If you decide to choose the current value use the previous result where the value was ignored; vice-versa,
- If you decide to ignore the current value use previous result where value was used.
``dp[i][j] = max(dp[i][j], dp[i-1][j] + arr[i], dp[i-1][j-1])``

### Examples
1. [House Robber](https://leetcode.com/problems/house-robber/)
1. [House Robber II](https://leetcode.com/problems/house-robber-ii/)
1. [Jump Game](https://leetcode.com/problems/jump-game/)
1. [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
1. [Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
1. [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
1. [Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

## Pattern 5: Kadane's Algorithm
### Problem Statement
Find the maximum sum of a subarray or subarray product in an array.

### Approach
- Use a sliding window approach to calculate the maximum sum or product at each position.
  ```
  max_ending_here = max(arr[i], max_ending_here + arr[i])
  ```

### Examples
1. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
1. [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
1. [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)

## Pattern 6: 0/1 Knapsack
### Problem Statement
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

### Approach
- Use a DP array to store the maximum value that can be achieved for every weight from 0 to W.
- If the weight of the current item is less than or equal to the current capacity, choose the maximum of including and excluding the item.
  ```
  dp[i][j] = max(dp[i-1][j], dp[i-1][j-wt[i]] + val[i])
  ```

### Examples
1. [0/1 Knapsack Problem](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
2. [Subset Sum](https://www.geeksforgeeks.org/subset-sum-problem-dp-25/)
3. [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
4. [Target Sum](https://leetcode.com/problems/target-sum/)
5. [Last Stone Weight](https://leetcode.com/problems/last-stone-weight-ii/)
6. [Minimum Subset Sum Difference](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/)
7. [Count of Subset Sum](https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/)



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
## Pattern 7: Unbounded Knapsack
### Problem Statement
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. An unlimited number of instances of each item can be used.

### Approach
- Use a DP array to store the maximum value that can be achieved for every weight from 0 to W.
- For each item, update the DP array by considering the maximum value achievable by including the item multiple times.

### Examples
1. [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
3. [Coin Change II](https://leetcode.com/problems/coin-change-2/)
4. [Integer Break](https://leetcode.com/problems/integer-break/)
5. [Rod Cutting](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)
6. [Maximum Ribbon Cut](https://www.geeksforgeeks.org/maximum-number-segments-lengths-b-c/)

### Code Examples
```java
// Unbounded Knapsack
public class UnboundedKnapsack {
    public int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }
}
```



## Pattern 8: Longest Increasing Subsequence (LIS)
### Problem Statement
Given an array, find the length of the longest increasing subsequence.

### Approach
- Use nested loops to build up the length of increasing subsequences.
- `dp[i] = max(dp[i], dp[j] + 1) if nums[i] > nums[j]`

### Examples
1. [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
1. [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
1. [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)
1. [Maximum Sum Increasing Subsequence](https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/)
1. [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/)
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

## Pattern 9: Longest Common Subsequence (LCS)
### Problem Statement
Given two strings, find the length of the longest common subsequence.

### Approach
- Compare characters of the two strings and build up the LCS.
  ```java
  if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1
  else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
  ```

### Examples
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

## Pattern 10: Palindromes
### Problem Statement
Given a string, find the longest palindromic subsequence or substring.

### Approach
- Use nested loops to find the length of the longest palindromic subsequence or substring.
  ```
  if (s[i] == s[j]) dp[i][j] = dp[i+1][j-1] + 2
  else dp[i][j] = max(dp[i+1][j], dp[i][j-1])
  ```

### Examples
1. [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
2. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
3. [Count of Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
4. [Minimum Insertions to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
5. [Minimum Deletions to Make a String Palindrome](https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/)
6. [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)
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
### Problem Statement
Given a sequence of matrices, find the most efficient way to multiply these matrices together.

### Approach
- Use nested loops to find the optimal order of matrix multiplication.
- `dp[i][j] = min(dp[i][k] + dp[k+1][j] + cost)`

### Examples
1. [Burst Balloons](https://leetcode.com/problems/burst-balloons/)
1. [Super Egg Drop](https://leetcode.com/problems/super-egg-drop/)
1. Evaluate expression to true / boolean parenthesize
1. Minimum or maximum value of a expression
1. Palindrome partitioning



## Pattern 9: DP on 2D Grids
### Problem Statement
Given a 2D grid, find the number of paths or the minimum path sum from one corner to another.

### Approach
- Use nested loops to calculate paths or sums based on adjacent cells.
- `dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]`

### Examples
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