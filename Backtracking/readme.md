# Introduction
Let us first review the problems of Permutations / Combinations / Subsets, 
since they are quite similar to each other and there are some common strategies to solve them.
First, their solution space is often quite large:
* Permutations: ``N!.``
* Combinations: ``C_N^k = N!/(N - k)!k!``
* Subsets: ``2^N`` since each element could be absent or present.
Given their exponential solution space, it is tricky to ensure that the generated solutions are complete and non-redundant. 
It is essential to have a clear and easy-to-reason strategy.

There are generally three strategies to do it:
* BFS Approach/Cascading/Branch and Bound
* Backtracking
* Lexicographic generation based on the mapping between binary bitmasks and the corresponding permutations/combinations/subsets.

## Backtracking
Recursion is the technique of calling a function within itself until it reaches a base case. Backtracking is 
an algorithmic technique that uses recursion to explore different possibilities to achieve some end goal
### 3 Keys to Backtracking
https://www.youtube.com/watch?v=Zq4upTEaQyM&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI
* **Choice & Decision Space**
Choices are the decisions you make that change the state of the problem. You select a choice based on your domain or decision space
* **The Constraints**
Constraints validate choices. They are the rules necessary to follow every time the state of our problem changes.
* **The Goal**
When do we know that the solution has been found?

```
void backtrack(arguments) {
	if (condition == true) { // Condition when we should stop our exploration.
		result.push_back(current);
		return;
	}
	for (int i = num; i <= last; i++) {
		current.push_back(i); // Explore candidate.
		backtrack(arguments);
		current.pop_back();   // Abandon candidate.
	}
}

```

![](https://miro.medium.com/max/1400/1*PFCNyVLbWlGlM0t8TtzqYg.png)

# Problems
[Backtracking Question Google Sheet](https://docs.google.com/spreadsheets/d/1SG7ZkuDb7eFx0aKMQNij5fd0C9E1waMfrBzArKUC6Ug/edit#gid=0)

# References
* https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/