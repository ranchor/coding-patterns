# Table of contents

- [Introduction](#introduction)
  - [3 Parts of a Successful Binary Search](#3-parts-of-a-successful-binary-search)
  - [Binary Search Template I](#binary-search-template-i)
  - [Binary Search Template II](#binary-search-template-ii)
  - [Binary Search Template III](#binary-search-template-iii)
  - [Exponential Binary Search (Binary Search on Infinite Arrays)](#exponential-binary-search-binary-search-on-infinite-arrays)
  - [Rotated Sorted Array (Search in Rotated Sorted Array)](#rotated-sorted-array-search-in-rotated-sorted-array)
  - [Fractional Binary Search](#fractional-binary-search)
  - [Binary Search Template Analysis(I,II and III)](#binary-search-template-analysisiii-and-iii)
- [Problems](#problems)
- [References](#references)

# Introduction
In its simplest form, Binary Search operates on a contiguous sequence with a specified left and right index. 
This is called the **Search Space**. Binary Search maintains the **left**, **right**, and **middle** indicies of 
the search space and compares the search target or applies the search condition to the middle value of the 
collection; if the condition is unsatisfied or values unequal, the half in which the target cannot lie is 
eliminated and the search continues on the remaining half until it is successful. If the search ends with an 
empty half, the condition cannot be fulfilled and target is not found.

## 3 Parts of a Successful Binary Search
Binary Search is generally composed of 3 main sections:
1. **Pre-processing** - Sort if collection is unsorted.
1. **Binary Search** - Using a loop or recursion to divide search space in half after each comparison.
1. **Post-processing** - Determine viable candidates in the remaining space.


## Binary Search Template I
Binary Search Template I is an advanced way to implement binary search. Use the element's right neighbor to determine if the condition is met and decide whether to go left or right. ``[l, r)``
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```

### Key Attributes:
* Use the element's right neighbor to determine if the condition is met and decide whether to go left or right
* Guarantees Search Space is at least 2 in size at each step
* Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
  
### Identification:
* The array is sorted.
* You need to find a value or element with a specific property in the array.

### Distinguishing Syntax:
* Initial Condition: ``left = 0, right = length``
* Termination: ``left == right``
* Searching Left: ``right = mid``
* Searching Right: ``left = mid+1``

### [MOST IMPORTANT] Modified Binary Search Template I
In this modified version of Template II, the left range is included, but the right range is not included ``([l, r))``, minimizing 'k' such that ``condition(k) is true``:

```java
int binarySearch(int[] nums){
  if(nums == null || nums.length == 0)
    return -1;

  int left =  min(search_space), right = max(search_space); // could be [0, n], [1, n] etc. Depends on problem
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(condition(m)) {
        right = mid;  // new range [l, m)
    } else {
        left = mid+1;  // new range [m+1, r)
    }       
  }
   
  return left;
}
```

## Binary Search Template II
Binary Search Template II is the most basic and elementary form of binary search. It includes  both the left and right left. ```[l, r]```

```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; } // new range [mid+1, right]
    else { right = mid - 1; } //// new range [left, mid-1]
  }

  // End Condition: left > right
  return -1;
}
```
### Key Attributes
* Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
* No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found

### Identification
* The array is sorted.
* You need to find a specific element in the array.
  
### Distinguishing Syntax
* Initial Condition: ``left = 0, right = length-1``
* Termination: ``left >= right``
* Searching Left: ``right = mid-1``
* Searching Right: ``left = mid+1``

### Modified Binary Search Template II
Both include the left and right left. ``[l, r]``, Minimize k , s.t. condition(k) is True
```java
int binarySearch(int[] nums){
  if(nums == null || nums.length == 0)
    return -1;

  int left =  min(search_space), right = max(search_space); // could be [0, n], [1, n] etc. Depends on problem
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(condition(m)) {
        right = mid-1; // new range [l, m-1]
    } else {
        left = mid+1;  // new range [m+1, r]
    }       
  }
   
  return left;
}
```



## Binary Search Template III
```java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}

```

### Key Attributes:
* Use element's neighbors to determine if the condition is met and decide whether to go left or right
* Gurantees Search Space is at least 3 in size at each step
* Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
  
### Identification:
* The array is sorted.
* The problem involves searching for an element, and you need to consider neighboring elements.

### Distinguishing Syntax:
* Initial Condition: ``left = 0, right = length-1``
* Termination: ``left + 1 == right``
* Searching Left: ``right = mid``
* Searching Right: ``left = mid``
  

### Modified Binary Search Template III
```java
     // minimize x such that condition(x) is true
    int binarySearchMin(int[] arr) {
        // decide what is the search space
        // hi should be able to take all possible values in the search space
        // lo points to an invalid value (the negative case of the if condition)
        int lo = -1, hi = arr.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (condition(arr, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        // in minimization template, hi contains the return index
        return hi;
    }

    // maximize x such that condition(x) is true
    int binarySearchMax(int[] arr) {
        // decide what is the search space
        // lo should be able to take all possible values in that search space
        // hi points to an invalid value (the negative case of the if condition)
        int lo = -1, hi = arr.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (condition(arr, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        // in maximization template, lo contains the return index
        return lo;
    }

    boolean condition(int[] arr, int idx) {
        // some condition on arr[idx]
        // return true or false
        return true;
    }

```


## Exponential Binary Search (Binary Search on Infinite Arrays)
This template is used for problems where you need to find an element in an unbounded array, and you don't know the size of the array in advance. It involves doubling the search space in each step until the target is found.
```java
int exponentialBinarySearch(int[] nums, int target) {
    int left = 0, right = 1;
    
    // Double the right index until we find a range that contains the target
    while (nums[right] < target) {
        left = right;
        right *= 2;
    }
    
    // Regular binary search within the found range
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1; // Not found
}
```

### Identification:
* The array is unbounded, infinite, or very large.
* You need to find an element or value in this unbounded array.



## Rotated Sorted Array (Search in Rotated Sorted Array)
This pattern is for searching in a rotated and sorted array. It's an adaptation of Template II with some modifications:
```java
public int searchInRotatedArray(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        }
        
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    return -1;
}
```
### Identification:
* The array is sorted but has been rotated at an unknown pivot point.
* You need to find an element or value in this rotated array.



## Fractional Binary Search
This template is used to find an optimal value within a given range that satisfies a specific condition or constraint. The condition function checks if the condition is met for a given value.

```java
double fractionalBinarySearch(double low, double high, double epsilon) {
    while (low + epsilon < high) {
        double mid = low + (high - low) / 2;

        if (condition(mid)) {
            high = mid;
        } else {
            low = mid;
        }
    }
    return low;  // or high, depending on the problem's requirements
}
```
Application to "Koko Eating Bananas" Problem:
```java
public double minEatingSpeed(int[] piles, int H) {
    double low = 1;  // Minimum possible eating rate
    double high = getMax(piles);  // Maximum possible eating rate
    double epsilon = 1e-5;  // Adjust epsilon based on precision requirements

    while (low + epsilon < high) {
        double mid = low + (high - low) / 2;

        if (canEatAll(piles, H, mid)) {
            high = mid;
        } else {
            low = mid;
        }
    }

    return low;  // The minimum eating rate that satisfies the condition
}

public boolean canEatAll(int[] piles, int H, double rate) {
    int hours = 0;
    for (int pile : piles) {
        hours += Math.ceil((double) pile / rate);  // Calculate hours required for each pile
    }
    return hours <= H;
}

public double getMax(int[] piles) {
    int max = Integer.MIN_VALUE;
    for (int pile : piles) {
        max = Math.max(max, pile);
    }
    return max;
}
```

## Binary Search Template Analysis(I,II and III) 
![](https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/Figures/binary_search/Template_Diagram.png)
### Template #1   (left < right):
* Search Condition needs to access the element's immediate right neighbor
* Use the element's right neighbor to determine if the condition is met and decide whether to go left or right
* **Example Problems**: Find the first occurrence of a target, minimum k for which condition(k) is true.
* **Key Attributes**: Post-processing is required. Loop/Recursion ends when you have 1 element left.

### Template #2   (left <= right):
* Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
* **Example Problems**: Standard binary search for finding an element.
* **Key Attributes**: No post-processing required.

### Template #3  (left + 1 < right):
* Search Condition needs to access element's immediate left and right neighbors
* Use element's neighbors to determine if the condition is met and decide whether to go left or right
* Guarantees Search Space is at least 3 in size at each step
* **Example Problems**: Finding peak elements, finding local minimum/maximum.
- **Key Attributes**: Guarantees the search space is at least 3 in size at each step. Post-processing required.

### Complexity Analysis
Time and Space Complexity: Runtime: ``O(log n)`` -- Logorithmic Time
Space: ``O(1)`` -- Constant Space

# Problems

# References
* [Binary Search for Beginners](https://leetcode.com/discuss/general-discussion/691825/Binary-Search-for-Beginners-Problems-or-Patterns-or-Sample-solutions) by @wh0ami
* [Leetcode Binary Search Explore Card](https://leetcode.com/explore/learn/card/binary-search)
* https://weixia.info/binary-search-template.html
* https://leetcode.com/discuss/general-discussion/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems
* https://leetcode.com/discuss/study-guide/2371234/An-opinionated-guide-to-binary-search-(comprehensive-resource-with-a-bulletproof-template)
