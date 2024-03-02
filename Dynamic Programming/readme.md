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

## Pattern 4: Unbounded Knapsack
1. [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
1. [Coin Change](https://leetcode.com/problems/coin-change/)
1. [Coin Change II](https://leetcode.com/problems/coin-change-2/)
1. [Rod Cutting](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)
1. [Maximum Ribbon Cut](https://www.geeksforgeeks.org/maximum-number-segments-lengths-b-c/)
1. [Minimum Cost for Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)


## Pattern 5: Longest Increasing Subsequence (LIS)
1. [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
1. [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
1. [Maximum Sum Increasing Subsequence](https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/)
1. [Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)
1. [Minimum Number of Removals to Make Mountain Array](https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/)

## Pattern 6: Longest Common Subsequence (LCS)
1. [Longest Common Substring](https://www.geeksforgeeks.org/longest-common-substring-dp-29/)
1. [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
1. [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
1. [Minimum Deletions and Insertions to Transform a String into another](https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/)
1. [Minimum deletions to make sequence sorted](https://www.geeksforgeeks.org/minimum-number-deletions-make-sorted-sequence/)
1. [Longest repeating subsequence](https://www.geeksforgeeks.org/longest-repeating-subsequence/)
1. [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/)
1. [Longest Alternating Subsequence](https://www.geeksforgeeks.org/longest-alternating-subsequence/)
1. [Edit Distance](https://leetcode.com/problems/edit-distance//)
1. [String Interleaving](https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/)

## Pattern 7: Palindromes
1. [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
1. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
1. [Count of Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
1. [Minimum insertions to make a string palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
1. [Minimum deletions to make a string palindrome](https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/)
1. [Palindromic Partitioning](https://leetcode.com/problems/palindrome-partitioning/)


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
* https://leetcode.com/discuss/study-guide/1308617/Dynamic-Programming-Patterns
* https://leetcode.com/discuss/general-discussion/662866/DP-for-Beginners-Problems-or-Patterns-or-Sample-Solutions
* https://leetcode.com/discuss/explore/april-leetcoding-challenge-2021/1159786/fibonacci-number-easy-solution-w-multiple-approaches-explained
* [Difference between Subarray, SubString, Subsequence and Subset](https://www.techiedelight.com/difference-between-subarray-subsequence-subset/)