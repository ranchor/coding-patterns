# Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
  - [BFS vs DFS](#bfs-vs-dfs)
  - [BFS Approaches](#bfs-approaches)
  - [DFS Iterative Traversal](#dfs-iterative-traversal)
    - [Inorder](#inorder)
    - [Preorder](#preorder)
    - [PostOrder](#postorder)
  - [DFS Recursive Traversal](#dfs-recursive-traversal)
    - [Inorder](#inorder)
    - [Preorder](#preorder)
    - [PostOrder](#postorder)
  - [BFS/Level Order Traversal](#bfslevel-order-traversal)
    - [Level Order Traversal](#level-order-traversal)
    - [Level Order Level By Level](#level-order-level-by-level)
    - [ZigZag Level Order](#zigzag-level-order)
  - [Patterns](#patterns)
    - [Traversals (BFS or DFS)](#traversals-bfs-or-dfs)
    - [View Problems](#view-problems)
    - [Basic Binary Tree problems](#basic-binary-tree-problems)
    - [Travel child to parent problems (Radial Traversal)](#travel-child-to-parent-problems-radial-traversal)
    - [Binary Search Tree (BST)](#binary-search-tree-bst)
    - [Lowest Common Ancestor(LCA) problems](#lowest-common-ancestorlca-problems)
    - [Root to leaf Path problems](#root-to-leaf-path-problems)
    - [Validate trees](#validate-trees)
    - [Serialize and Deserialize tree](#serialize-and-deserialize-tree)
    - [Tree Construction Problems](#tree-construction-problems)
- [Problems](#problems)
- [References](#references)

# Introduction

## BFS vs DFS
There are two ways to traverse the tree: DFS depth first search and BFS breadth first search. Here is a small summary
![](https://leetcode.com/problems/binary-tree-right-side-view/Figures/199_rewrite/traversals.png)
> Which approach to choose, BFS or DFS?
* If problem is associated with each level, so it's the way more natural to implement BFS here.
* Time complexity is the same `O(N)` both for DFS and BFS since one has to visit all nodes.
* Space complexity is `O(H)` for DFS and
  `O(D)` for BFS, where `H` is a tree height, and `D` is a tree diameter. They both result in 
  `O(N)` space in the worst-case scenarios: skewed tree for DFS and complete tree for BFS.

## BFS Approaches
There are **multiple ways to implement the level order traversal** especially when it comes to 
identifying the level of a particular node which are as follows:
* We can add a pair of `(node, level)` to the queue and whenever we add the children of a node, we add `(node.left,  parent_level + 1)` and `(node.right, parent_level + 1)`. 
this approach wouldn't be very efficient for our algorithm since we need all the nodes on the same level and we would need another data structure just for that.
![](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/Figures/116/img2.png)
* **Two queues, one for the previous level and one for the current**:
* **One queue with sentinel to mark the end of the level**: A more memory efficient way of segregating the same level nodes is to use some demarcation between the levels. 
Usually, we insert a `NULL` entry in the queue which marks the end of the previous level and the start of the next level. 
This is a great approach but again, it would still consume some memory proportional to the number of levels in the tree.
![](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/Figures/116/img3.png)
* **[RECOMMENDED]** **One queue + level size measurement**: The approach we will be using here would have a nested loop structure to get around the requirement of a NULL pointer. 
Essentially, at each step, we record the size of the queue and that always corresponds to all the nodes on a particular level. 
Once we have this size, we only process these many elements and no more. By the time we are done processing size number of elements, 
the queue would contain all the nodes on the next level. Here's a pseudocode for the same:
    ```java
     while (!Q.empty())
     {
         size = Q.size()
         for i in range 0..size
         {
             node = Q.pop()
             Q.push(node.left)
             Q.push(node.right)
         }
     }
    ```

## DFS Iterative Traversal
### Inorder
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            // At this point, the leftmost node is at the top of the stack
            current = stack.pop();
            list.add(current.val);
            // Move to the right subtree
            current = current.right;
        }

        return list;
    }
}
```

### Preorder
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);

            if(root.right != null)
                stack.push(root.right);
            if(root.left != null)
                stack.push(root.left);
        }
        
        
        return list;
    }
}
```

### PostOrder
**Postorder from Preorder - Reverse the steps of pushing left and right child into stack and reverse full list in the end.**
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.left != null)
                stack.add(root.left);
            if(root.right != null)
                stack.add(root.right);
        }
        Collections.reverse(list);
        return list;
    }
}

```

## DFS Recursive Traversal
### Inorder
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    } 
}
```
### Preorder
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
```
### PostOrder
```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}
```
## BFS/Level Order Traversal
### Level Order Traversal
```java
class Solution {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            root = q.poll();
            result.add(root.val);
            if(root.left != null)
                q.add(root.left);
            if(root.right != null)
                q.add(root.right);
        }
        
        return result;
    }
}
```
### Level Order Level By Level
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            List<Integer> level = new ArrayList();
            while(size-- > 0) {
                root = q.poll();
                level.add(root.val);
                if(root.left != null)
                    q.add(root.left);
                if(root.right != null)
                    q.add(root.right);
            }
            result.add(level);
        }
        
        return result;
    }
}
```
### ZigZag Level Order
```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean isLevelOdd = false;
        while(q.size() > 0) {
            int size = q.size();
            List<Integer> level = new ArrayList();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                level.add(root.val);
                if(root.left != null)
                    q.add(root.left);
                if(root.right != null)
                    q.add(root.right);
            }
            if(isLevelOdd) 
                Collections.reverse(level);
            result.add(level);
            isLevelOdd = !isLevelOdd;
        }
        
        return result;
    }
}
```

## Patterns

### Traversals (BFS or DFS)
1. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal)
1. [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal)
1. [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal)
1. [Level Order Traversal
](https://leetcode.com/problems/binary-tree-level-order-traversal)
1. [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
1. [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
1. [Binary Tree Vertical Order Traversal](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)
1. [Diagonal Traverse](https://leetcode.com/problems/diagonal-traverse/)

### View Problems
1. [Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)
1. [Left Side View](https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article)
1. [Bottom View](https://www.geeksforgeeks.org/bottom-view-binary-tree/)
1. [Top View](https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/)
1. [Boundary Traversal of Binary Tree](https://leetcode.com/problems/boundary-of-binary-tree/)

### Basic Binary Tree problems
1. [Same Tree](https://leetcode.com/problems/same-tree/)
2. [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
3. [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
4. [Maximum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) 
5. [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
6. [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
7. [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
8. [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees)
9. [Binary Tree Tilt](https://leetcode.com/problems/binary-tree-tilt)

### Travel child to parent problems (Radial Traversal)
In such type of problem we given target node [any node in tree also possibly root] and travel level by level from that node to finding ans.
**Template**
* Build parent and child relation map
* Do level order traversal or DFS
1. [All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)
1. [Amount of Time for Binary Tree to Be Infected](https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/)


### Binary Search Tree (BST)
Use the property of BST judiciously (the left subtree will always contain nodes with value less than root's value and 
right subtree will contain nodes with value greater than root's value)
```
left < root < right    // BST Property
```
#### Searching
```java
 public TreeNode search(TreeNode root, int key) {
    if (root == null || root.val == key) return root;
    if (root.val < key) return search(root.right, key);
    return search(root.left, key);
}
```
#### Insertion
```java
 public void insert(int key) {
        root = insertRec(root, key);
}
    
private TreeNode insertRec(TreeNode root, int key) {
    if (root == null) {
        root = new TreeNode(key);
        return root;
    }
    if (key < root.val) {
        root.left = insertRec(root.left, key);
    } else if (key > root.val) {
        root.right = insertRec(root.right, key);
    }
    return root;
}
```
#### Deletion
* Three cases to consider:
    * Node to be deleted has no children: Simply remove the node.
    * Node to be deleted has one child: Replace the node with its child.
    * Node to be deleted has two children: Find the inorder successor (or predecessor), copy its value to the node to be deleted, and then recursively delete the inorder successor (or predecessor).

**Time Complexity**

| Operation   | Average Case | Worst Case |
|-------------|--------------|------------|
| Insertion   | O(log n)     | O(n)       |
| Deletion    | O(log n)     | O(n)       |
| Searching   | O(log n)     | O(n)       |



1. [Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree)
2. [Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree)
3. [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)
4. [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)
5. [Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)
6. [Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/)
7. [Trim a Binary Search Tree](https://leetcode.com/problems/trim-a-binary-search-tree)
8. [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst)
9. [All Elements in Two Binary Search Trees](https://leetcode.com/problems/all-elements-in-two-binary-search-trees)

### Lowest Common Ancestor(LCA) problems
Template for LCA in Binary Tree
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Base case: if root is null or root is either p or q, return root
    if (root == null || root == p || root == q) {
        return root;
    }

    // Recursively search left and right subtrees
    TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
    TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

    // If both left and right subtrees return non-null values,
    // then the current node is the LCA
    if (leftLCA != null && rightLCA != null) {
        return root;
    }

    // If only one subtree returns a non-null value, propagate it upwards
    return leftLCA != null ? leftLCA : rightLCA;
}
```
* If ``p`` and ``q`` are found in different subtrees, the current node is their LCA.
* If ``p`` or ``q`` is found only in the left subtree, return the result from the left subtree.
* If ``p`` or ``q`` is found only in the right subtree, return the result from the right subtree.
1. [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree)
1. [Lowest Common Ancestor of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/description/)
1. [Lowest Common Ancestor of a Binary Tree III](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/)
1. [Lowest Common Ancestor of a Binary Tree IV](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/)
1. [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree)
1. [Lowest Common Ancestor of Deepest Leaves](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves)

### Root to leaf Path problems
You are given root, you have to perform operations on a path, (path is root to leaf). 
Think upon the type of traversal you will apply when going from root to leaf.
```java
 private void traversePath(TreeNode root, List<Integer> path, List<String> result) {
        // Base case: If the current node is null, return
        if (root == null) return;
        
        // Add current node to the path
        path.add(root.val);
        
        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            // Perform operations on the path
            // Example: result.add(String.join("->", path)); // for Binary Tree Paths problem
        }
        
        // Recursively traverse left and right subtrees
        traversePath(root.left, path, result);
        traversePath(root.right, path, result);
        
        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }
```
1. [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/description/)
2. [Path Sum](https://leetcode.com/problems/path-sum/description/)
3. [Path Sum II](https://leetcode.com/problems/path-sum-ii/description/)
4. [Sum root to leaf numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
5. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)
6. [Path Sum III](https://leetcode.com/problems/path-sum-iii/description/)
7. [Pseudo-Palindromic Paths in a Binary Tree](https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/)

### Validate trees
1. [Validate Binary Tree Nodes](https://leetcode.com/problems/validate-binary-tree-nodes/)
2. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

### Serialize and Deserialize tree
#### Serialize
* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
* *Serialize binary tree*: In that case we converting binary structure or object into string using preorder.(encode)

#### Deserialize
* Reconstruct the tree from serailize sequence data(string)
* *Deserialize binary tree*: converting string to binary tree using preorder (decode)

1. [Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/)
1. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
1. [Serialize and Deserialize N-ary Tree](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/description/)


#### General Strategy
* **The common approach is to use a preorder recursion(serialization) and Queue(deserialization)**
* For serialization, use preorder traversal to create a string representation of the tree with delimiters to separate node values.
* For deserialization, use a queue to process the string and rebuild the tree by creating nodes and linking them based on the serialized order.
https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/solutions/364841/java-common-template-serialization-deserialization-of-bt-bst-n-ary-tree/ 

#### Serialize and Deserialize BST 
**here we need to make sure when we de-serialize, we insert the nodes to maintain the BST order.**

```java
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeBST(root, sb);
        
        return sb.toString();
    }
    private void serializeBST(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val).append(",");
        serializeBST(root.left, sb);
        serializeBST(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeBT(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode deserializeBT(Queue<String> q, Integer low, Integer high){
        if(q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.valueOf(s);
        
        if(val < low || val > high) return null;
        q.poll();
        
        TreeNode root = new TreeNode(val);
        root.left = deserializeBT(q, low, val);
        root.right = deserializeBT(q, val, high);
        
        return root;
    }
}
```

#### Serialize and Deserialize Binary Tree 
**no need to compare the values, just append them to the string.**

```java
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeBT(root, sb);
        return sb.toString();
    }
    private void serializeBT(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
        }else{
            sb.append(root.val).append(",");
            serializeBT(root.left, sb);
            serializeBT(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeBT(q);
    }
    private TreeNode deserializeBT(Queue<String> q){
        String s = q.poll();
        if(s.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserializeBT(q);
        root.right = deserializeBT(q);
        return root;
    }
}
```

#### Serialize and Deserialize N-ary Tree
**here, we append the no.of children of each node, so that we can call that many no.of time the recursive function.**

```java
class Codec {

// Encodes a tree to a single string.
public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}
 
private void serialize(Node root, StringBuilder sb){
    if(root == null) {
      sb.append("#").append(",");   
    }else{
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for(Node child : root.children){
            serialize(child, sb);
        }
    }      
}
// Decodes your encoded data to tree.
public Node deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(q);
}
private Node deserialize(Queue<String> q){
    String s = q.poll();
    if(s.equals("#")) return null;
    
    Node root = new Node(Integer.valueOf(s));
    int children = Integer.valueOf(q.poll());
    
    root.children = new ArrayList<>();
    for(int i=0; i< children; i++){
        root.children.add(deserialize(q));
    }
    return root;
}
}
```




### Tree Construction Problems
Tree construction problems often involve building a tree from given traversal orders (preorder, inorder, postorder). The key is to understand the properties of each traversal and how to use them to reconstruct the tree.

#### General Strategy
* Start from not inorder traversal, usually it's a preorder or postorder one, and use the traversal picture above to define the strategy to pick the nodes. For example, for preorder traversal the first value is a root, then its left child, then its right child, etc. For postorder traversal the last value is a root, then its right child, then its left child, etc
* The value picked from preorder/postorder traversal splits the inorder traversal into left and right subtrees. The only information one needs from inorder - if the current subtree is empty (= return None) or not (= continue to construct the subtree).

1. **Preorder and Inorder**:
    * The first element in the preorder traversal is the root.
    * Use the inorder traversal to determine the left and right subtrees.
    * Recursively build the left and right subtrees.
    
    ```java
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inorderMap);
        return root;
    }
    ```

2. **Postorder and Inorder**:
    * The last element in the postorder traversal is the root.
    * Use the inorder traversal to determine the left and right subtrees.
    * Recursively build the left and right subtrees.
    
    ```java
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inorderMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inorderMap);
        root.right = buildTreeHelper(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inorderMap);
        return root;
    }
    ```

1. [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
1. [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
1. [Construct Binary Tree from Preorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)
1. [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
1. [Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)

# Problems

# References
* https://leetcode.com/discuss/study-guide/1212004/binary-trees-study-guide
* https://leetcode.com/discuss/interview-question/1282328/trees-patterns-topics-sample-problems
* https://leetcode.com/discuss/study-guide/937307/Iterative-or-Recursive-or-DFS-and-BFS-Tree-Traversal-or-In-Pre-Post-and-LevelOrder-or-Views
* https://leetcode.com/discuss/study-guide/1337373/Tree-question-pattern-oror2021-placement
* https://leetcode.com/discuss/study-guide/3743769/Crack-Easily-Any-Interview-or-Tree-Data-Structure-Patterns-With-Questions

