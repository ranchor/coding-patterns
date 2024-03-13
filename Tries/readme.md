# Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
  - [How to represent a Trie?](#how-to-represent-a-trie)
    - [Using Array](#using-array)
    - [Using Map](#using-map)
  - [Insertion in Trie](#insertion-in-trie)
  - [Search in Trie](#search-in-trie)
  - [Complexity Analysis](#complexity-analysis)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
  - [Application](#application)
- [Problems](#problems)
- [References](#references)

# Introduction
**Trie**, also called **prefix tree**, is a special form of a **Nary tree**.Typically, a **trie** is used to store strings. 
Each Trie node represents a string **(a prefix)**. Each node might have several children nodes while the paths to different 
children nodes represent different characters. And the strings the child nodes represent will be the origin string 
represented by the node itself plus the character on the path
![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/07/screen-shot-2018-01-31-at-163403.png)

![](https://assets.leetcode.com/users/images/a5d337f7-707d-4c1b-a36f-f2a08a5b349d_1604920420.1003854.png)
## How to represent a Trie?
### Using Array

For instance, if we store strings which only contains letter ``a`` to ``z``, we can declare an array whose size is ``26`` in each 
node to store its children nodes. And for ``a`` specific character ``c``, we can use ``c - 'a'`` as the index to find the 
corresponding child node in the array.
```java
class TrieNode {
    // change this value to adapt to different cases
    public static final N = 26;
    public TrieNode[] children;
    boolean isWordEnd;
    TrieNode() {
        children = new TrieNode[N];
        isWordEnd = false;
    }
};

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
}
```
It is really fast to visit a child node. It is comparatively easy to visit a specific child since we can 
easily transfer a character to an index in most cases. But not all children nodes are needed. 
So there might be some waste of space

### Using Map
We can declare a **hashmap** in each node. The key of the hashmap are characters and the value is the corresponding child node.
```java
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWordEnd;
    
    TrieNode() {
        this.children = new HashMap<>();
        this.isWordEnd = false;
    }
};

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
}
```
It is even easier to visit a specific child directly by the corresponding character. But it might be a little slower 
than using an array. However, it saves some space since we only store the children nodes we need. 
It is also more flexible because we are not limited by a fixed length and fixed range.

## Insertion in Trie
Inserting a word in the trie is pretty simple now. We start from the root, iterate over the characters of the new word, 
and move along the nodes and edges, creating them when needed. Here is the full code:

* **Using Map**
```java
public void insert(TrieNode root, String word) {
    TrieNode currentNode = root;
    for (char c : word.toCharArray()) {
        if (!currentNode.children.containsKey(c)) {
            // insert a new node if the path does not exist
            currentNode.children.put(c, new TrieNode());
        }
        currentNode = currentNode.children.get(c);
    }
    currentNode.isWordEnd = true;
}
```
* Using Array
```java
public void insert(TrieNode root, String word) {
    TrieNode currentNode = root;
    int childIndex;
    for (char c : word.toCharArray()) {
        childIndex = c-'a';
        if (currentNode.children[childIndex]==null) {
            // insert a new node if the path does not exist
            currentNode.children[childIndex]= new TrieNode();
        }
        currentNode = currentNode.children[childIndex];
    }
    currentNode.isWordEnd = true;
}
```


## Search in Trie
* Using Map
```java
public boolean search(TrieNode root, String word) {
    TrieNode currentNode = root;
    for (char c : word.toCharArray()) {
        if (!currentNode.children.containsKey(c)) {
            return false;
        }
        currentNode = currentNode.children.get(c);
    }
    return currentNode.isWordEnd;
}
```
* Using Array
```java
public boolean search(TrieNode root, String word) {
    TrieNode currentNode = root;
    int childIndex;
    for (char c : word.toCharArray()) {
        childIndex = c-'a';
        if (currentNode.children[childIndex]==null) {
            return false;
        }
        currentNode = currentNode.children[childIndex];
    }
    return currentNode.isWordEnd;
}
```

## Complexity Analysis
### Time Complexity
Time complexity of all **insert**, **search** and **startsWith** methods will be ``O(N)`` where ``N`` is the longest 
length of word.
### Space Complexity
``O(M*N*K)``  where ``M`` words to insert in total and the length of words is at most ``N``,
Let's assume that there are maximum ``K ``different characters (K is equal to 26 in this problem, but might differs in different cases). 
So each node will maintain a map whose size is at most ``K``.

## Application
* [Autocomplete](https://en.wikipedia.org/wiki/Autocomplete)
* [Spell checker](https://en.wikipedia.org/wiki/Spell_checker)
* [IP routing (Longest prefix matching)](https://en.wikipedia.org/wiki/Longest_prefix_match)
* [T9 predictive text](https://en.wikipedia.org/wiki/T9_(predictive_text)
* [Solving word games](https://en.wikipedia.org/wiki/Boggle)


# Problems


# References
* https://leetcode.com/explore/learn/card/trie/
* https://leetcode.com/discuss/general-discussion/931977/beginner-friendly-guide-to-trie-tutorial-practice-problems