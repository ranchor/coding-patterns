# Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
  - [Identification Strategy](#identification-strategy)
  - [Types of Sliding Window](#types-of-sliding-window)
  - [Fixed-Size Window Template](#fixed-size-window-template)
  - [Dynamic Size Window Template](#dynamic-size-window-template)
    - [General Template](#general-template)
    - [Modified Template (Counting)](#modified-template-counting)
  - [Important Notes](#important-notes)
- [Problems](#problems)
- [References](#references)

# Introduction
The Sliding Window pattern is used to perform a required operation on a specific window size of a given array or
linked list, such as finding the longest subarray containing all 1s. Sliding Windows start from the 1st element and
keep shifting right by one element and adjust the length of the window according to the problem that you are solving.
In some cases, the window size remains constant and in other cases the sizes grows or shrinks.

![alt text](https://cdn-images-1.medium.com/max/800/0*FxacnhM3xBA0fJbm)

## Identification Strategy
**Ways to identify when the given problem might require a sliding window:**
* The problem input is a linear data structure such as a **linked list, array, or string.**
* You’re asked to find the **_longest/shortest/number of_** **_substrings_**, **_subarrays_**, or a desired value with
 _**with (At most/Exactly)**_ K elements that fit some constraints.
* There is an apparent naive or brute force solution that runs in ``O(N²)``, ``O(2^N)`` or some other large time complexity.

## Types of Sliding Window
* **Fixed-size window length k(Move Along)**: The length of the window is fixed, and it asks you to find something in the window such as
the maximum sum of all windows, the maximum or median number of each window. Usually we need kind of variables to
maintain the state of the window, some are as simple as an integer, or it could be as complicated as some advanced data
structure such as list, queue or deque.
* **Dynamic Size Window(Two pointers + criteria):** the window size is not fixed, usually it asks you to find the
subarray that meets the criteria, for example, given an array of integers, find the number of arrays whose sum
is equal to a target value.

## Fixed-Size Window Template
This template is used for problems where you need to find the maximum, minimum, or a specific value within a fixed-size window as it moves through the array. The window size is fixed, and you keep track of a moving window by adding elements to the right and removing elements from the left.
```java
public int slidingWindowFixed(int[] arr, int k) {
    int left = 0;
    int windowSum = 0;
    int right = 0;

    while (right < arr.length) {
        // Expand the window by including the new element
        windowSum += arr[right];
        right++;

        if (right - left+1>= k) {
            // Process the current window, e.g., calculate average, max, or other properties

            // Slide the window by one element
            windowSum -= arr[left];
            left++;
        }
    }

    return result;
}

```

## Dynamic Size Window Template
* **Step1**: Have a counter or hash-map to count specific array input and keep on increasing the window toward right using outer loop.
* **Step2**: Have while loop inside to reduce the window side by sliding toward right. Movement will be based on
 constraints of problem. Go through few examples below
* **Step3**: Store the current maximum window size or minimum window size or number of windows based on problem requirement.

### General Template
```java
int left = 0, right = 0;

while (right < arr.length) {
    // Expand the window to the right
    // Update window properties if needed
    window.add(s[right]);
    right++;

    while (valid /* condition for valid window */) {
       // Update validity condition if necessary
       // Shrink the window
        window.remove(s[left]);
        left++;
    }
}
```

### Modified Template (Counting)
```java
public int slidingWindowCounting(int[] arr, int k) {
    Map<Character, Integer> charFrequency = new HashMap();
    int left=0, right = 0;

    while (right < arr.length) {
        // Update the frequency of elements within the window
        // Expand the window by including the new element

        while (charFrequency.size() > k) {
            // Shrink the window from the left
            // Update the frequency as elements leave the window
            charFrequency.put(arr[left], charFrequency.get(arr[left]) - 1);
            if (charFrequency.get(arr[left]) == 0) {
                charFrequency.remove(arr[left]);
            }
            left++;
        }

        // Calculate properties or perform actions on the current window
        right++;
    }

    return result;
}
```

```java
 public List<Integer> slidingWindowTemplateForSubstringProblems(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
        //Two Pointers: left - left pointer of the window; right - right pointer of the window
        int left = 0, right = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(right < s.length()){
            
            char tempRight = s.charAt(right);//get a character
            
            if( map.containsKey(tempRight) ){
                map.put(tempRight, map.get(tempRight)-1);// plus or minus one
                if(map.get(tempRight) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            right++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempLeft = s.charAt(left);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempLeft)){
                    map.put(tempLeft, map.get(tempLeft) + 1);//plus or minus one
                    if(map.get(tempLeft) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                left++;
            }
        }
        return result;
    }
```

* Data type of the window can vary depending on the situation, such as using the hash table as the counter, or you can use an array to do the same, since we only deal with English letters.
* Slightly tricky part is the valid condition, and we might have to write a lot of code to get this updated in real time.
**Sliding Window Template to solve all substring related problems**
```
A sliding window is an abstract concept commonly used in array/string problems.
A window is a range of elements in the array/string which usually defined by the start and end indices,
i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction.
For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).
```
A general way is to use a hashmap assisted with two pointers

## Important Notes
* For substring problems using sliding windows left and right are [i, j)[i,j) (left-closed, right-open). If we need
  to find max/min length then do that after updating right indices. Eg:
```
right++;
maxLength = Math.max(maxLength, right-left);
```

# Problems

| **Problem**                                                                                                                                                                     | **Difficulty** | **TC** | **SC**      | **Notes**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | ------ | ----------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)                                                                               | Easy           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Fixed Size] [Mimumum sum of subarray of size k](https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/)                                                       | Easy           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Fixed Size] [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)                                                                            | Easy           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Dynamic-SubArray] [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)                                                                        | Medium         | O(n)   | O(1)        | Using Dynamic Sliding Window pattern of Two Pointers, for outer loop we keep moving **right** pointer,  in inner loop for Valid Window condition we keeping moving **left** pointer till the sum is greater that target to get minimum length. Remember right is exclusive(pointing to the element just beyond the window) and left is inclusive(pointing to the first element inside the window).                                                                                                              |
| [Dynamic-SubArray] [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)                                                                  | Medium         | O(n)   | O(1)        | Using Dynamic Sliding Window pattern of Two Pointers, for outer loop we keep moving **right** pointer,  in inner loop for Invalid Window condition we keeping moving **left** pointer until prod is greater or equal to K. In outer loop we keep calculating the result**(result += windowRight - windowLeft)**. Remember right is exclusive and left is inclusive.                                                                                                                                             |
| [Dynamic-SubArray] [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/)                                                                            | Medium         | O(n)   | O(1)        | Using Dynamic Sliding Window pattern of Two Pointers, for outer loop we keep moving **right** pointer,  in inner loop for Invalid Window condition we keeping moving **left** pointer until count of zeros greater than 1. In outer loop we keep calculating the result. Remember right is exclusive and left is inclusive.                                                                                                                                                                                     |
| [Dynamic-SubArray] [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)                                                                          | Medium         | O(n)   | O(1)        | Using Dynamic Sliding Window pattern of Two Pointers, for outer loop we keep moving **right** pointer,  in inner loop for Invalid Window condition we keeping moving **left** pointer until count of zeros greater than K. In outer loop we keep calculating the result. Remember right is exclusive and left is inclusive.                                                                                                                                                                                     |
| [Dynamic-SubString] [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)                             | Medium         | O(N)   | O(min(m,n)) | Using Dynamic Sliding Window Strategy of Two Pointers and HashMap to remember the frequency of each character processed.                                                                                                                                                                                                                                                                                                                                                                                        |
| [Dynamic-SubString] [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/) | Medium         | O(N)   | O(1)        | Using Dynamic Sliding Window Strategy of Two Pointers and HashMap. Use outer right loop to remember the frequency of each character processed by using right pointer. If size of hashMap is greater than two then in inner loop keep move the left pointer till the map size decrease to two.  Remember right is exclusive and left is inclusive.                                                                                                                                                               |
| [Dynamic-SubString] [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)                 | Medium         | O(N)   | O(1)        | Using Dynamic Sliding Window Strategy of Two Pointers and HashMap to remember the frequency of each character processed. Generalized approach for above problem.                                                                                                                                                                                                                                                                                                                                                |
| [Dynamic-SubString] [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)                                           | Medium         |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Dynamic-SubString] [Fruits into Baskets](https://leetcode.com/problems/fruit-into-baskets/)                                                                                    | Medium         |        |             | Using Dynamic Sliding Window Strategy of Two pointers and HashMap, for outer loop we keep moving right pointer and recording frequency of each unique fruit type,  in inner loop for size of hashmap greater than two we keeping moving left pointer by decreasing frequency of respective fruit type until size of hashMap less than two. In outer loop we keep calculating the max result of right-left. Remember right is exclusive and left is inclusive.                                                   |
| [Dynamic_SubString] [Permutation in String](https://leetcode.com/problems/permutation-in-string/)                                                                               | Medium         |        |             | Use Dynamic Substring Sliding Window template using HashMap and Counter. For outer loop we keep moving right pointer till we get desriable or valid window. In inner loop for Valid window condition we keep moving the left pointers till the window become invalid. In inner loop we update results collections only if difference between right and left equal to target length. Remember right is exclusive and left is inclusive.  Anagrams, Pemutation and Minimum Window substring are related questions |
| [Dynamic-SubString] [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)                                                               | Medium         |        |             | Same as above                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [Dynamic-SubString] [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)                                                                         | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Dynamic-SubString] [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)                                       | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Dynamic-SubString] [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)                                                                             | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Minimum Number of K Consecutive Bit Flips](https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/)                                                           | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Count Unique Characters of All Substrings of a Given String](https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/)                       | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [Minimum Window Subsequence](https://leetcode.com/problems/minimum-window-subsequence/)                                                                                         | Hard           |        |             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |


# References
* [Important] [Sliding Window algorithm template in java](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem)
* [Important] https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
* https://zengruiwang.medium.com/sliding-window-technique-360d840d5740
* https://leetcode.com/discuss/study-guide/1773891/Sliding-Window-Technique-and-Question-Bank
* https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/slidingwindowtechnique
* [Aditya Verma Sliding Window Video Playlist](https://youtube.com/playlist?list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj)