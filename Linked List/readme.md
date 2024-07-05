# Table of contents

  
# Introduction
This guide covers essential patterns and techniques for solving various linked list problems commonly found in technical interviews and competitive programming.

## [Pattern#1] In-Place Reversal of Linked List
In many problems, you may be asked to reverse the links between a set of nodes in a linked list. The constraint is often that you need to do this in-place, i.e., using the existing node objects and without using extra memory. This is where this pattern is useful. The pattern reverses one node at a time, starting with one variable (`current`) pointing to the head of the linked list, and another variable (`previous`) pointing to the previous node that you have processed. In a lock-step manner, you will reverse the current node by pointing it to the previous before moving on to the next node. Also, you will update the variable `previous` to always point to the previous node that you have processed.

 ![alt text](https://cdn-images-1.medium.com/max/800/0*ffeU1_ViGSyI-uEc) 

 ### Iterative Reversal Technique
**Basic Implementation:**
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    
    return prev;
}
```

### Recursive Reversal Technique
**Basic Implementation:**
```java
public ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode p = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
```

## [Pattern#2] Fast and Slow Pointers Pattern
The **Fast and Slow pointer** approach, also known as the **Hare & Tortoise algorithm (Floyd's Cycle Finding Algorithm)**, is a pointer algorithm that uses two pointers moving through the **array (or sequence/linked list)** at different speeds. This approach is quite useful when dealing with cyclic linked lists or arrays. By moving at different speeds (say, in a cyclic linked list), the algorithm proves that the two pointers are bound to meet. The fast pointer should catch the slow pointer once both pointers are in a cyclic loop.

![alt text](https://cdn-images-1.medium.com/max/800/0*4gc5y94y7S2N5Hfq) 

### Key Points to Remember
- Slow and fast pointers definitely meet (because they enter a cycle).
- The entry point to the cycle is the duplicate number.
- **fastPtr** would become **NULL** when there are **even elements in the list** and **not NULL for odd elements.**
- The meeting point of slow and fast pointers is exactly at the same distance from the start to the entry point.
- Use **Dummy Node/Dummy Head** when the head can be modified or changed during problem-solving.
- An alternative to Floyd's Cycle Finding Algorithm for detecting cycles is **HashTable** or **HashSet** with space complexity as **O(n)**.


```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```
**Detecting a Cycle in a Linked List**
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        if (slow == fast) {
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
```
**Finding the Start of the Cycle**
```java
public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            hasCycle = true;
            break;
        }
    }
    if (!hasCycle) {
        return null;
    }
    ListNode ptr1 = head;
    ListNode ptr2 = slow;
    while (ptr1 != ptr2) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
    }
    return ptr1;  // Start of the cycle
}
```

### Proof of the Meeting Point of Slow and Fast Pointers

#### Basic Idea:
When using the Fast and Slow pointers method to detect a cycle in a linked list, the fast pointer moves twice as fast as the slow pointer. If there is a cycle, the fast pointer will eventually catch up to the slow pointer within the cycle. The key insight is that the meeting point of the slow and fast pointers is at the same distance from the start of the linked list to the entry point of the cycle.

#### Step-by-Step Explanation:

1. **Initialization**:
   - Both pointers (`slow` and `fast`) start at the head of the linked list.
   - The `slow` pointer moves one step at a time.
   - The `fast` pointer moves two steps at a time.

2. **Meeting in the Cycle**:
   - When they meet inside the cycle, the fast pointer has traveled twice the distance of the slow pointer. Let's denote the distance the slow pointer has traveled by `d`.
   - The fast pointer, therefore, has traveled `2d`.

3. **Cycle Length and Distances**:
   - Let's break down the distances:
     - `L`: The distance from the start of the list to the beginning of the cycle.
     - `C`: The length of the cycle.
     - `K`: The distance from the start of the cycle to the meeting point within the cycle.

4. **Relationship Between Distances**:
   - By the time the slow and fast pointers meet:
     - The slow pointer has traveled `L + K` (one complete pass through the non-cyclic part and `K` within the cycle).
     - The fast pointer has traveled `L + K + nC` (where `n` is the number of complete cycles it has made within the cycle).

5. **Equation**:
   - Since the fast pointer moves twice as fast, we can write:
     - `2(L + K) = L + K + nC`
   - Simplify this to:
     - `2L + 2K = L + K + nC`
     - `L + K = nC` (after subtracting `L + K` from both sides).

6. **Conclusion**:
   - The equation `L + K = nC` shows that the distance `L` (from the start to the cycle's entry point) plus `K` (the distance from the cycle entry to the meeting point) equals `nC` (a multiple of the cycle length).
   - This means that when the slow and fast pointers meet, the distance they have traveled aligns such that if you start another pointer at the head of the list and move both the slow pointer and this new pointer one step at a time, they will meet at the cycle's entry point.

So, the distance from the start of the linked list to the meeting point of the slow and fast pointers is equal to the distance from the start to the cycle's entry point. This proves that the meeting point is exactly at the same distance from the start to the entry point of the cycle.


## [Pattern#3] Two Pointers Linked List
The two pointers technique involves using two pointers to solve various linked list problems, such as finding the kth node from the end, merging two sorted lists, or detecting intersections.

### Example 1: Finding the Kth Node from the End
```java
public ListNode findKthFromEnd(ListNode head, int k) {
    ListNode first = head;
    ListNode second = head;
    
    for (int i = 0; i < k; i++) {
        if (first == null) return null;
        first = first.next;
    }
    
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    
    return second;
}
```

### Example 2: Merging Two Sorted Lists
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    
    if (l1 != null) {
        current.next = l1;
    } else {
        current.next = l2;
    }
    
    return dummy.next;
}
```


## Understanding and Utilizing Dummy Nodes in Linked Lists
### Introduction
A dummy node, also known as a **sentinel node**, is a special node placed at the front or end of a linked list. 
It simplifies operations, eliminates special-case handling, and ensures a consistent structure.
### Benefits
* **Consistent Logic**: The use of a dummy node eliminates the need for special-case handling when the head node needs to be deleted.
* **Simplified Code**: The code becomes more straightforward and less error-prone, making it easier to understand and maintain.
* **Avoiding Null Checks**: Dummy nodes help prevent null pointer exceptions by ensuring a valid node is always available to work with.
### Examples
* Pseudo Code for Using a Dummy Node:
```java
ListNode dummy = new ListNode(-1); // Initialize a dummy node with a value or null
dummy.next = head; // Link the dummy node to the original head of the list
ListNode current = dummy; // Start iterating from the dummy node

// Perform operations using 'current' and 'current.next' as needed

return dummy.next; // Return the new head, which may be the dummy node
```
* Deleting a Specific Value from a Linked List without a Dummy Node
```java
Node deleteValue(Node head, int value) {
    // Handle the case where the head of the list needs to be deleted
    while (head != null && head.data == value) {
        head = head.next;
    }
    
    Node current = head;
    
    while (current != null && current.next != null) {
        if (current.next.data == value) {
            current.next = current.next.next;  // Skip the node to be deleted
        } else {
            current = current.next;
        }
    }
    
    return head;
}
```
* Deleting a Specific Value from a Linked List with a Dummy Node
```java
  Node deleteValueWithDummy(Node head, int value) {
    Node dummy = new Node(0);
    dummy.next = head;  // Link the dummy node to the head of the list
    
    Node current = dummy;
    
    while (current != null && current.next != null) {
        if (current.next.data == value) {
            current.next = current.next.next;  // Skip the node to be deleted
        } else {
            current = current.next;
        }
    }
    
    return dummy.next;  // Return the list starting from the node after the dummy
}

```
* Inserting a Node at the Tail of a Linked List Without Dummy Node :
```java
Node insertAtTail(Node oldTail, int i){
    Node newTail = new Node(i);
    if(oldTail == null) {
        return newTail;
    }
    oldTail.next = newTail;
    return newTail;
}

```
* Inserting a Node at the Tail of a Linked List With Dummy Node:
```java
Node dummy = new Node(0);
Node oldTail = dummy;


oldTail = insertAtTail(oldTail, 1);
Node insertAtTail(Node dummy, int i){
    Node newTail = new Node(i);
    dummy.next = newTail;
    return newTail;
}
```



# Problems


# References
* https://leetcode.com/discuss/study-guide/1800120/Become-Master-In-Linked-List
* https://leetcode.com/discuss/study-guide/2725900/Linked-list-study-guide
* https://leetcode.com/problems/find-the-duplicate-number/discuss/72875/slow-fast-pointer-solution-with-key-ideas-explained
