# Table of contents

- [Introduction](#introduction)
  - [Simple Stack Template](#simple-stack-template)
  - [Monotonic Increasing/Decreasing Stack Template](#monotonic-increasingdecreasing-stack-template)
  - [Balanced Parentheses Template](#balanced-parentheses-template)
  - [Expression Evaluation Template](#expression-evaluation-template)
  - [Two Stacks Template](#two-stacks-template)
- [Problems](#problems)
- [References](#references)

# Introduction

## Simple Stack Template
This template is used for problems where you need to perform simple operations on elements, such as pushing elements onto a stack. The elements are typically processed sequentially as they are encountered.
``` java
void stackPattern(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    
    for (int num : nums) {
        // Process the current element (num)
        stack.push(num);
    }
    
    // Process elements in the stack (if needed)
}
```

## Monotonic Increasing/Decreasing Stack Template
A monotonic stack is a stack whose elements are monotonically **increasing** or **decreasing.**
Sometimes we store the index of the elements in the stack and make sure the elements corresponding 
to those indexes in the stack forms a mono-sequence.

Monotonic stack is like a regular stack with one key distinction in the push operation: 
* Before we push a new element onto the stack, we first check if adding it breaks the monotonic condition. 
* If it does, then we pop the top element off the stack until pushing the new element no longer breaks the 
monotonic condition.

There are four types of monotonic stacks:
1. **Strictly increasing** - every element of the stack is strictly greater than the previous element. Example - [1, 4, 5, 8, 9]
2. **Non-decreasing** - every element of the stack is greater than or equal to the previous element. Example - [1, 4, 5, 5, 8, 9, 9]
3. **Strictly decreasing** - every element of the stack is strictly smaller than the previous element - [9, 8, 5, 4, 1]
4. **Non-increasing** - every element of the stack is smaller than or equal to the previous element. - [9, 9, 8, 5, 5, 4, 1]


### Generic Monotonic Stack Template 
```
Initialize a monotonic stack.
Iterate over the input array:
    If the current element is greater than or equal to the top element of the stack:
        Pop the top element of the stack.
    Push the current element onto the stack.
Return the stack.
```

```java
import java.util.Stack;

public void buildMonoStack(int[] arr) {
    // Initialize an empty stack
    Stack<Integer> stack = new Stack<>();
    
    // Iterate through all the elements in the array
    for (int i = 0; i < arr.length; i++) {
        while (!stack.isEmpty() && compare(arr[stack.peek()], arr[i])) {
            // If the previous condition is satisfied, we pop the top element
            int stackTop = stack.pop();
            
            // Do something with stackTop here, e.g.
            // nextGreater[stackTop] = i
        }
        
        if (!stack.isEmpty()) {
            // If the stack has some elements left
            // Do something with stack top here, e.g.
            // previousGreater[i] = stack.peek()
        }

        // At the end, we push the current index into the stack
        stack.push(i);
    }
    
    // At all points in time, the stack maintains its monotonic property
}

// Define the compare function for your specific operator
// For example, for strictly increasing stack: return arr[a] < arr[b]
private boolean compare(int a, int b) {
    // Replace this with your desired operator (e.g., <, <=, >, >=)
    return a < b;
}
```
* We can replace the ``compare`` method with  the desired operator for different types of monotonic stacks.
* For each variation looks like as follows:

|  Problem           |  Stack Type                  |  Operator in while loop |  Assignment Position  |
|--------------------|------------------------------|-------------------------|-----------------------|
|  next greater      |  decreasing (equal allowed)  |  stackTop < current     |  inside while loop    |
|  previous greater  |  decreasing (strict)         |  stackTop <= current    |  outside while loop   |
|  next smaller      |  increasing (equal allowed)  |  stackTop > current     |  inside while loop    |
|  previous smaller  |  increasing (strict)         |  stackTop >= current    |  outside while loop   |


### Next Greater Element in Right (Decreasing or Non-Increasing Stack)
``arr = [13, 8, 1, 5, 2, 5, 9, 7, 6, 12]``
``nextGreaterElements = [null, 9, 5, 9, 5, 9, 12, 12, 12, null]``

```java
import java.util.Stack;

public int[] findNextGreaterIndexes(int[] arr) {
    // Initialize an empty stack
    Stack<Integer> stack = new Stack<>();
    
    // Initialize nextGreater array, this array holds the output
    // Initialize all the elements to -1 (invalid value)
    int[] nextGreater = new int[arr.length];
    Arrays.fill(nextGreater, -1);
    
    // Iterate through all the elements of the array
    for (int i = 0; i < arr.length; i++) {
        // While loop runs until the stack is not empty AND
        // the element represented by stack top is STRICTLY SMALLER than the current element
        // This means, the stack will always be monotonic non-increasing (type 4)
        while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            // Pop out the top of the stack; it represents the index of the item
            int stackTop = stack.pop();
            
            // As given in the condition of the while loop above,
            // the nextGreater element of stackTop is the element at index i
            nextGreater[stackTop] = i;
        }
        
        // Push the current element
        stack.push(i);
    }
    
    return nextGreater;
}

```
### Previous Greater Element (Strickly Decreasing Stack)
``arr = [13, 8, 1, 5, 2, 5, 9, 7, 6, 12]``
``[null, 13, 8, 8, 5, 8, 13, 9, 7, 13]``
```java
import java.util.Stack;

public int[] findPreviousGreaterIndexes(int[] arr) {
    // Initialize an empty stack
    Stack<Integer> stack = new Stack<>();
    
    // Initialize previousGreater array, this array holds the output
    // Initialize all the elements to -1 (invalid value)
    int[] previousGreater = new int[arr.length];
    Arrays.fill(previousGreater, -1);
    
    // Iterate through all the elements of the array
    for (int i = 0; i < arr.length; i++) {
        // While loop runs until the stack is not empty AND
        // the element represented by stack top is SMALLER OR EQUAL to the current element
        // This means the stack will always be strictly decreasing (type 3)
        // because elements are popped when they are equal, so equal elements will never stay in the stack
        while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
            // Pop out the top of the stack; it represents the index of the item
            stack.pop();
        }
        
        // After the while loop, only the elements which are greater than the current element are left in the stack
        // This means we can confidently decide the previous greater element of the current element i, which is the stack top
        if (!stack.isEmpty()) {
            previousGreater[i] = stack.peek();
        }
        
        // Push the current element
        stack.push(i);
    }
    
    return previousGreater;
}

```

### Next Smaller Element in Right (Increasing or Non-Decreasing Stack)

```java
import java.util.Stack;

public int[] findNextSmallerIndexes(int[] arr) {
    // Initialize an empty stack
    Stack<Integer> stack = new Stack<>();
    
    // Initialize nextSmaller array; this array holds the output
    // Initialize all the elements to -1 (invalid value)
    int[] nextSmaller = new int[arr.length];
    Arrays.fill(nextSmaller, -1);
    
    // Iterate through all the elements of the array
    for (int i = 0; i < arr.length; i++) {
        // While loop runs until the stack is not empty AND
        // the element represented by stack top is STRICTLY LARGER than the current element
        // This means the stack will always be monotonic non-decreasing (type 2)
        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            // Pop out the top of the stack; it represents the index of the item
            int stackTop = stack.pop();
            
            // As given in the condition of the while loop above,
            // nextSmaller element of stackTop is the element at index i
            nextSmaller[stackTop] = i;
        }
        
        // Push the current element
        stack.push(i);
    }
    
    return nextSmaller;
}

```

### Previous Smaller Element (Strickly Increasing Stack)
```java
import java.util.Stack;

public int[] findPreviousSmallerIndexes(int[] arr) {
    // Initialize an empty stack
    Stack<Integer> stack = new Stack<>();
    
    // Initialize previousSmaller array; this array holds the output
    // Initialize all the elements to -1 (invalid value)
    int[] previousSmaller = new int[arr.length];
    Arrays.fill(previousSmaller, -1);
    
    // Iterate through all the elements of the array
    for (int i = 0; i < arr.length; i++) {
        // While loop runs until the stack is not empty AND
        // the element represented by stack top is LARGER OR EQUAL to the current element
        // This means the stack will always be monotonic strictly increasing (type 1)
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            // Pop out the top of the stack; it represents the index of the item
            int stackTop = stack.pop();
        }
        
        // This is the additional part
        if (!stack.isEmpty()) {
            // The index at the stack top refers to the previous smaller element for the `i`th index
            previousSmaller[i] = stack.peek();
        }
        
        // Push the current element
        stack.push(i);
    }
    
    return previousSmaller;
}

```


**For a mono-decreasing stack:**
* we need to pop smaller elements before pushing. 
* it keep tightening the result as lexigraphically greater as possible. (Because we keep popping smaller elements out and keep greater elements).
![](../../../../../src/main/resources/monostack.png)

### When to Use Monotonic Stack
If a problem is suitable to use monotonic stack, it must has at least three characters:
* It is a “range queries in an array” problem.
* The minima/maxima element or the monotonic order of elements in a range is useful to get answer of every range query.
* When a element is popped from the monotonic stack, it will never be used again.

## Balanced Parentheses Template
Another common stack pattern is the balanced parentheses pattern. This pattern is used to solve problems that require checking whether a string of parentheses is balanced.
General template for solving balanced parentheses problems:

```java
Initialize an empty stack.
Iterate over the input string:
    If the current character is an opening parenthesis:
        Push the current character onto the stack.
    If the current character is a closing parenthesis:
        If the stack is empty or the top element of the stack does not match the current character:
            Return false.
        Pop the top element of the stack.
Return true.
```


##  Expression Evaluation Template
This template is used for problems that involve evaluating mathematical expressions involving operators, parentheses, and operands using two stacks: one for values and one for operators. The expression is processed, and the result is obtained using the stack.
```java
int evaluateExpression(String expression) {
    Stack<Integer> values = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    // Process the expression and perform calculations
    
    return values.peek(); // Result of the evaluated expression
}

```

## Two Stacks Template
This template is useful in scenarios where you want to efficiently perform operations like pop and peek on a stack while maintaining the order of elements pushed into it.It's commonly used in problems where you need to simulate a queue using two stacks or efficiently implement a stack that supports pop and peek operations with O(1) amortized time complexity.
```java
class TwoStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public TwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
```

## Trapping Rain Water Template
This pattern helps solve problems related to trapping rainwater between heights.

``` java
public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int water = 0;
    for (int i = 0; i < height.length; i++) {
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                break;
            }
            int distance = i - stack.peek() - 1;
            int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
            water += distance * boundedHeight;
        }
        stack.push(i);
    }
    return water;
}
```

# Problems
# References
* https://leetcode.com/discuss/study-guide/2347639/A-comprehensive-guide-and-template-for-monotonic-stack-based-problems
* https://leetcode.com/discuss/study-guide/3168516/A-general-approach-to-stack-problems-in-C%2B%2B-or-Generic-Template