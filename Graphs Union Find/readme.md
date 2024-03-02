# Table of contents

- [Introduction](#introduction)
  - [Terminologies](#terminologies)
  - [Implementing “disjoint sets”](#implementing-disjoint-sets)
  - [Ways to implement a “disjoint set”.](#ways-to-implement-a-disjoint-set)
  - [Implementation with Quick Find](#implementation-with-quick-find)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
  - [Implementation with Quick Union](#implementation-with-quick-union)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
  - [Implementation with Union by Rank](#implementation-with-union-by-rank)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
  - [Implementation with Path Compression](#implementation-with-path-compression)
- [Questions](#questions)
  - [[Medium]  Graph Valid Tree](#medium--graph-valid-tree)
    - [Approach 1: Union-Find Algorithm](#approach-1-union-find-algorithm)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
    - [Approach 2: Union-Find Algorithm - Union By Rank and Path Compression](#approach-2-union-find-algorithm---union-by-rank-and-path-compression)
    - [Time Complexity](#time-complexity)
    - [Space Complexity](#space-complexity)
- [References](#references)

# Introduction
Union Find (or Disjoint Set) Data Structure helps to address the connectivity between the components of a network.
The “network“ here can be a computer network or a social network. For instance, we can use a disjoint set to determine 
if two people share a common ancestor.To check if two vertices are connected, we only need to check if they have the same root node.
![](https://leetcode.com/explore/learn/card/Figures/Graph_Explore/Disjoint_Set_1_edited.png)

## Terminologies
* **Parent node**: the direct parent node of a vertex. For example, in Figure 5, the parent node of vertex 3 is 1, 
the parent node of vertex 2 is 0, and the parent node of vertex 9 is 9.
* **Root node**: a node without a parent node; it can be viewed as the parent node of itself. 
For example, in Figure 5, the root node of vertices 3 and 2 is 0. As for 0, it is its own root node and parent node. Likewise, the root node and parent node of vertex 9 is 9 itself. Sometimes the root node is referred to as the head node.

## Implementing “disjoint sets”
* The ``find`` function locates the root node of a given vertex. For example, in Figure 5, the output of the find function for vertex 3 is 0.
* The ``union`` function unions two vertices and makes their root nodes the same. In Figure 5, if we union vertex 4 and vertex 5, their root node will become the same, which means the union function will modify the root node of vertex 4 or vertex 5 to the same root node.

## Ways to implement a “disjoint set”.
* Implementation with Quick Find
* Implementation with Quick Union

## Implementation with Quick Find

```java
// UnionFind.class
class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        // Initially, all elements are in their own set.
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // find - O(1)
    public int find(int x) {
        return root[x];
    }
		
    // union - O(n)    
    public void union(int x, int y) {
        int rootOfX = find(x);
        int rootOfY = find(y);
        if (rootOfX != rootOfY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootOfY) {
                    root[i] = rootOfX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

### Time Complexity
|  | Union-find Constructor | Find |  Union | Connected |
|---|---|---|---|---|
| Time Complexity | ``O(N)`` | ``O(1)`` | ``O(N)`` | ``O(1)`` |
### Space Complexity
We need ``O(N)`` space to store the array of size ``N.``


## Implementation with Quick Union
```java
class UnionFind {
    private int[] parents;

    public UnionFind(int size) {
        parents = new int[size];
        for (int i = 0; i < size; i++) {
             // Initially, all elements are in their own set
            parents[i] = i;
        }
    }

    public int find(int x) {
        while (x != parents[x]) {
            x = parents[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootOfX = find(x);
        int rootOfY = find(y);
        if (rootOfX != rootOfY) {
            parents[rootOfY] = rootOfX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```
Quick Union is more efficient than Quick Find. 

### Time Complexity
|  | Union-find Constructor | Find |  Union | Connected |
|---|---|---|---|---|
| Time Complexity | ``O(N)`` | ``O(N)`` | ``O(N)`` | ``O(N)`` |
### Space Complexity
We need ``O(N)`` space to store the array of size ``N.``

## Implementation with Union by Rank
### Time Complexity
|  | Union-find Constructor | Find |  Union | Connected |
|---|---|---|---|---|
| Time Complexity | ``O(N)`` | ``O(logN)`` | ``O(logN)`` | ``O(logN)`` |
### Space Complexity
We need ``O(N)`` space to store the array of size ``N.``

## Implementation with Path Compression

# Questions

## [Medium]  Graph Valid Tree
[Leetcode](https://leetcode.com/problems/graph-valid-tree/), [GeeksForGeeks](https://www.geeksforgeeks.org/union-find/), 
### Approach 1: Union-Find Algorithm
```
Let there be 4 elements 0, 1, 2, 3

Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
     2   3   
    /
   1
 /
0

Do Union(2, 3)
         3    
        /
      2
     /
   1
 /
0
```
```
public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int p1 = findParent(parents, edge[0]);
            int p2 = findParent(parents, edge[1]);

            if (p1 == p2) {
                return false;
            }

            union(parents, p1, p2);
            --n;
        }

        return n == 1;
    }

    private int findParent(int[] parents, int node) {
        if (parents[node] == node) {
            return parents[node];
        }

        parents[node] = findParent(parents, parents[node]);
        return parents[node];
    }

    private void union(int[] parents, int p1, int p2) {
        parents[p2] = parents[p1];
    }

```
### Time Complexity
Implementation of union() and find() is naive and takes O(n) time in the worst case.
### Space Complexity
### Approach 2: Union-Find Algorithm - Union By Rank and Path Compression
```
Let us see the above example with union by rank
Initially, all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
   1    3
 /  \
0    2

Do Union(2, 3)
    1    
 /  |  \
0   2   3
```
### Time Complexity
### Space Complexity



# References
* https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3881/
* https://jojozhuang.github.io/algorithm/algorithm-union-find/
* https://leetcode.com/discuss/general-discussion/1072418/Disjoint-Set-Union-(DSU)Union-Find-A-Complete-Guide

