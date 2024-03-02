# Table of contents
- [Introduction](#introduction)
  - [Identification Strategy](#identification-strategy)
  - [Types of Two Pointers Patterns](#types-of-two-pointers-patterns)
    - [[Pattern#1] Collision/Running from both ends of an array - One array, move from two sides to middle.](#pattern1-collisionrunning-from-both-ends-of-an-array---one-array-move-from-two-sides-to-middle)
    - [[Pattern#2] Forward - One array, both move forward](#pattern2-forward---one-array-both-move-forward)
    - [[Pattern#3] Parallel - Two arrays, each array has been assigned with a pointer.](#pattern3-parallel---two-arrays-each-array-has-been-assigned-with-a-pointer)
    - [[Pattern#4] Split & Merge of an array / Divide & Conquer](#pattern4-split--merge-of-an-array--divide--conquer)
- [Problems](#problems)
- [References](#references)

# Introduction
Two Pointers is a pattern where two pointers iterate through the data structure in tandem until one or both of the pointers
hit a certain condition.Two Pointers is often useful when searching pairs in a **sorted array(or Linked Lists);**
for example, when you have to compare each element of an array to its other elements.
![](../../../resources/twopointers.png)

## Identification Strategy
**Ways to identify when to use the Two Pointer method:**
* It will feature problems where you deal with sorted arrays (or Linked Lists)
  and need to find a set of elements that fulfill certain constraints
* The set of elements in the array is a pair, a triplet, or even a subarray
* For eg: take a look at this problem:
  > Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

To solve this problem, we can consider each element one by one (pointed out by the first pointer) and iterate through
the remaining elements (pointed out by the second pointer) to find a pair with the given sum.
The time complexity of this algorithm will be `O(N^2)` where `‘N’` is the number of elements in the input array.

Given that the input array is sorted, an efficient way would be to start with one pointer in the
beginning and another pointer at the end. At every step, we will see if the numbers pointed by the two pointers
add up to the target sum. If they do not, we will do one of two things:
1. If the sum of the two numbers pointed by the two pointers is greater than the target sum,
   this means that we need a pair with a smaller sum. So, to try more pairs, we can decrement the end-pointer.
2. If the sum of the two numbers pointed by the two pointers is smaller than the target sum,
   this means that we need a pair with a larger sum. So, to try more pairs, we can increment the start-pointer.

## Types of Two Pointers Patterns

### [Pattern#1] Collision/Running from both ends of an array - One array, move from two sides to middle.
The first type of problems are, having two pointers at left and right end of array, then moving them to the center while processing something with them.
![](https://assets.leetcode.com/users/images/83674944-3be0-4974-b7a8-e59319b896c7_1642138224.1528904.jpeg)

#### Two/K Sum
* [Two Sum](https://leetcode.com/problems/two-sum/)
* [3 Sum](https://leetcode.com/problems/3sum/)
* [3 Sum Closest](https://leetcode.com/problems/3sum-closest/)
* [3 Sum Smaller](https://leetcode.com/problems/3sum-smaller/)
* [4 Sum](https://leetcode.com/problems/4sum/)

#### Reversing/Swapping
```
public void reverse(char[] str) {
    int i = 0, j = str.length - 1;
    while (i < j) {
        swap(str, i, j);
        i++;
        j--;
    }
}
private void swap(char[] str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
}
```
* [Valid Palindrome](https://leetcode.com/problems/valid-palindrome)
* [Reverse String](https://leetcode.com/problems/reverse-string/)
* [Sort Colors](https://leetcode.com/problems/sort-colors/)
* [BackSpace String Compare](https://leetcode.com/problems/backspace-string-compare/)
* [Reverse Words in a String II](https://leetcode.com/problems/reverse-words-in-a-string-ii/)
* [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

#### Trapping Water
* [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
* [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

### [Pattern#2] Forward - One array, both move forward
Next type is using two pointers with different speed of movement. Typically they starts from the left end,
then the first pointer advances fast and give some feedback to the slow pointer and do some calculation.
![](https://assets.leetcode.com/users/images/f6ecb6b1-679e-48f9-91b5-de4602436865_1642138215.8872066.jpeg)
#### Fast and Slow
* [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)
* [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii)
* [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)
#### Sliding Window/Caterpillar Method
* [Longest Substring Without Repeating Characters ](https://leetcode.com/problems/longest-substring-without-repeating-characters)
#### Remove Duplicate
* [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
#### Rotation
* [Rotate Array](https://leetcode.com/problems/rotate-array/)

### [Pattern#3] Parallel - Two arrays, each array has been assigned with a pointer.
In this category, you will be given 2 arrays or lists, then have to process them with individual pointers.
```
[IMPORTANT] Interview Tip: Whenever you're trying to solve an array problem in-place, always consider the possibility of iterating 
backwards instead of forwards through the array. It can completely change the problem, and make it a lot easier.
```
![](https://assets.leetcode.com/users/images/2a44123b-9acb-4dbc-b230-d313a37039c9_1642138206.7972002.jpeg)
#### Sorted arrays
* [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
#### Intersections/LCA
* [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

### [Pattern#4] Split & Merge of an array / Divide & Conquer
The last one is similar to previous category but there is one thing is added. First, you need to split the given list
into 2 separate lists and then do two pointers approach to merge or unify them. There aren't many tasks here.
![](https://assets.leetcode.com/users/images/1d3c2ed7-95ca-440d-9693-f3e31360b826_1642138190.9125686.jpeg)
#### Partition
* [Partition List](https://leetcode.com/problems/partition-list/)
#### Sorting
* [Sort List](https://leetcode.com/problems/sort-list/)


# Problems



# References
* https://leetcode.com/discuss/study-guide/1688903/Solved-all-two-pointers-problems-in-100-days
* https://leetcode.com/articles/two-pointer-technique/
* https://jojozhuang.github.io/algorithm/algorithm-two-pointers/
* https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA