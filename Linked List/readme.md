# Table of contents

  
# Introduction
## [Pattern#1] In-Place Reversal of Linked List
In a lot of problems, you may be asked to reverse the links between a set of nodes of a linked list. 
Often, the constraint is that you need to do this in-place, i.e., using the existing node objects and without 
using extra memory. This is where the above mentioned pattern is useful.
This pattern reverses one node at a time starting with one variable (current) pointing to the head of the linked list, 
and one variable (previous) will point to the previous node that you have processed. In a lock-step manner, 
you will reverse the current node by pointing it to the previous before moving on to the next node. Also, 
you will update the variable “previous” to always point to the previous node that you have processed.
 ![alt text](https://cdn-images-1.medium.com/max/800/0*ffeU1_ViGSyI-uEc) 

## [Pattern#2] Fast and Slow Pointers Pattern
The **Fast and Slow pointer** approach, also known as the **Hare & Tortoise algorithm(Floyd's Cycle Finding 
Algorithm)**,  is a pointer algorithm that uses two pointers which move through the **array (or sequence/linked list)** 
at different speeds. This approach is quite useful when dealing with cyclic linked lists or arrays.
By moving at different speeds (say, in a cyclic linked list), the algorithm proves that the two pointers are bound to 
meet. The fast pointer should catch the slow pointer once both the pointers are in a cyclic loop.
![alt text](https://cdn-images-1.medium.com/max/800/0*4gc5y94y7S2N5Hfq) 

### Key Points to Remember
* Slow and fast ptr definitely meet (because they enter a cycle)
* Entry point to the cycle is the duplicate number.
* **fastPtr** would become **NULL** when there are **even elements in the list** and **not NULL for odd elements.**
* Meeting point of slow and fast pointers is exactly at the same distance from start to enter point.
* Use **Dummy Node/Dummy Head** when head can be modified or changed during the course of the problem-solving.
* Alternative to Floyd's Cycle Finding Algorithm for detecting cycle is **HashTable** or **HashSet** with space 
  complexity as **O(n)**

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```


## [Pattern#3] Two Pointers Linked List



## Understanding and Utilizing Dummy Nodes in Linked Lists
### Introduction
* A dummy node, also known as a **sentinel node**, is a special node placed at the front or end of a linked list.
* It serves as a tool to simplify linked list operations, eliminate the need for special-case handling, and ensure a consistent structure.
* Dummy nodes ensure that there is always a valid node to work with, reducing code complexity and preventing null pointer exceptions.
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
