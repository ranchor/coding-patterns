# Introduction
Heap patterns are a set of problem-solving techniques that leverage the use of Priority Queues (Heaps), a powerful data structure for maintaining and manipulating elements with specific order criteria. These patterns are particularly useful in situations where you need to efficiently access, update, or process elements based on their priority, frequency, or value.

## Basics of PriorityQueue/Heap
* PriorityQueue is an implementation of a min-heap (by default) or max-heap (with a custom comparator).
* Elements are ordered by their natural order or according to the provided comparator.
* The top element (at the front of the queue) is the smallest (min-heap) or largest (max-heap) element.
  
### Initialization
* Initialize a min-heap: 
``PriorityQueue<T> pq = new PriorityQueue<>();``
* Initialize a max-heap: 
``PriorityQueue<T> pq = new PriorityQueue<>(Collections.reverseOrder());``
* Initialize with a custom comparator: 
``PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> compare(a, b));``

### Common Operations
* ``add(e)`` or ``offer(e)``: Adds an element to the queue.
* ``poll()``: Removes and returns the top element.
* ``peek()``: Returns the top element without removing it.
* ``remove(e)``: Removes the specified element.
* ``size()``: Returns the number of elements in the queue.

###  Time Complexity:
* Insertion (add/offer): ``O(log n)``
* Removal (poll): ``O(log n)``
* Peek: ``O(1)``

### Priority Queue vs. Normal Queue
* PriorityQueues prioritize elements based on their values or the custom comparator.
* Normal queues follow the first-in-first-out (FIFO) order.


# Patterns

## [Pattern#1] Top K Elements
Any problem that asks us to find the **top/smallest/frequent ‘K’ elements** among a given set falls under this pattern.

The best data structure to keep track of ‘K’ elements is **Heap (Priority Queues)**. This pattern will make use of the Heap to solve 
multiple problems dealing with ‘K’ elements at a time from a set of given elements. The pattern looks like this:
 ![alt text](https://cdn-images-1.medium.com/max/800/0*rhqGUjza4c7xuHy5)

### Using Priority Queues
* Insert ‘K’ elements into the min-heap or max-heap based on the problem.
* Iterate through the remaining numbers and if you find one that is larger than what you have in the heap, 
then remove that number and insert the larger one.
* The ``Collections.reverseOrder()`` comparator can be used to create a ``max-heap``

There is no need for a sorting algorithm because the heap will keep track of the elements for you.

### Identification Strategy
* This pattern is widely applicable when you need to find the K smallest or largest elements.

## [Pattern#2] K Way Merge
K-way Merge helps you solve problems that involve a set of sorted arrays.Whenever you’re given ‘K’ sorted arrays, you can use a Heap to efficiently perform a sorted traversal of all the
elements of all arrays. You can push the smallest element of each array in a Min Heap to get the overall minimum. After getting the overall minimum, push the next element from the same array to the heap. Then, repeat this process 
to make a sorted traversal of all elements.
 ![alt text](https://cdn-images-1.medium.com/max/800/0*bXCTQM9s_0i-zNqU)

### Pseudo Code
1. Initialize a **Min Heap (PriorityQueue)** or an array to store K pointers, one for each array.
2. Insert the first element of each array in a Min Heap.
3. While the heap is not empty or the array of pointers is not exhausted:
   1. Get the smallest element from the heap (or the element pointed to by the smallest pointer).
   2. Add the smallest element to the merged result.
   3. Move the pointer of the array from which the smallest element was taken.
   4. Insert the next element from the same array into the heap or array.
4. The merged result is a sorted array.

### Identification Strategy
* The problem will feature sorted arrays, lists, or a matrix
* If the problem asks you to merge sorted lists, find the smallest element in a sorted list.
  
## [Pattern#3] Two Heaps
In many problems, where we are given a set of elements such that we can divide them into two parts. 
To solve the problem, we are interested in knowing the smallest element in one part and the biggest element 
in the other part. This pattern is an efficient approach to solve such problems.

This pattern uses two Heaps to solve these problems; A **Min Heap** to find the smallest element and a **Max Heap** to find the biggest element. 

### Pseudo Code:
1. Maintain two Heaps: a **Min Heap** to keep track of the larger half and a **Max Heap** for the smaller half.
2. Insert elements into the appropriate heap based on their values:
   1. If an element is smaller than the largest element in the Min Heap, insert it into the Max Heap.
   2. If an element is larger, insert it into the Min Heap.
3. Keep the heaps balanced so that the difference in the number of elements between them is at most 1.
4. To find the median or balance the elements, the top elements of the two heaps may be used.


### Identification Srategy
* Useful in situations like Priority Queue, Scheduling.
* If the problem states that you need to find the smallest/largest/median elements of a set.
* Sometimes, useful in problems featuring a binary tree data structure

## [Pattern#4] Minimum Number
* [Minimum cost to connect sticks/ropes](https://leetcode.com/problems/minimum-cost-to-connect-sticks/)
* [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)
* [Employee Free Time](https://leetcode.com/problems/employee-free-time)
* [Minimum cost to hire K Workers](https://leetcode.com/problems/minimum-cost-to-hire-k-workers/)
* [Minimum number of CPU (Task Scheduler)](https://leetcode.com/problems/task-scheduler/)
* [Minimum number of Refueling stops LeetCode](https://leetcode.com/problems/minimum-number-of-refueling-stops/)
  
# Problems

# References
* https://leetcode.com/discuss/general-discussion/1127238/master-heap-understanding-4-patterns-where-heap-data-structure-is-used
* https://rnyt.medium.com/master-heap-data-structure-adc1b99b5471