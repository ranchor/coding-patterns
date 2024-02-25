# Table of contents

- [Introduction](#introduction)
  - [Implementations](#implementations)
    - [Using Kahn's BFS Based Algorithm](#using-kahns-bfs-based-algorithm)
    - [Using DFS Based Algorithm](#using-dfs-based-algorithm)
- [Problems](#problems)
- [References](#references)

# Introduction
* Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering.
* So, To find the Topological sorting for a graph, we just have to find in-degrees of each vertex and order the nodes from **least in-degree to the highest.**
* Topological Sorting for a graph is not possible if the graph is not a DAG.

![](https://assets.leetcode.com/users/images/63bd7ad6-403c-42f1-b8bb-2ea41e42af9a_1613794080.8115625.png)

## Implementations
### Using Kahn's BFS Based Algorithm
The approach is based on the below fact that, A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
#### Algorithm
1. Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.
1. Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
1. Remove a vertex from the queue (Dequeue operation) and then.
    1. Increment count of visited nodes by 1.
    1. Decrease in-degree by 1 for all its neighbouring nodes.
    1. If in-degree of a neighbouring nodes is reduced to zero, then add it to the queue.
1. Repeat Step 3 until the queue is empty.
1. If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
**How to find in-degree of each node?**
There are 2 ways to calculate in-degree of every vertex-
* Take an in-degree array which will keep track of traverse the array of edges and simply increase the counter of the destination node by 1.
* [Use this]Traverse the adjacent list for every node and then increment the in-degree of all the nodes connected to it by 1.

![](https://assets.leetcode.com/users/images/53a3192e-3b39-4003-ab02-ce9299d1e854_1613794475.1125915.png)
```
indegree = an array indicating indegrees for each node
neighbours = a HashMap recording neighbours of each node
queue = []
for i in indegree:
    if indegree[i] == 0:
        queue.append(i)
		
while !queue.empty():
    node = queue.dequeue()
    for neighbour in neighbours[node]:
        indegree[neighbour] -= 1
        if indegree[neighbour] == 0:
            queue.append(neighbour)
```
#### Time Complexity
O(V+E). The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
#### Space Complexity
O(V). The queue needs to store all the vertices of the graph

### Using DFS Based Algorithm
The key observation is that, leaf nodes should always come after their parents and ancestors. Following this intuition we can apply DFS and output nodes from leaves to the root.

#### Algorithm
1. We can modify DFS to find Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices.
1. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
1. Finally, print contents of the stack.
1. **Note** that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack.
![](https://media.geeksforgeeks.org/wp-content/uploads/20200818211917/Topological-Sorting-1.png)
![](https://assets.leetcode.com/users/images/e482f21d-a612-4333-ac80-807eb90c1495_1613794550.934654.png)

```
def topological_sort():
    for each node:
        if visited[node] is False:
            dfs(node)

def dfs(node):
    visited[node] = True
    for nei in neighbours[node]:
        dfs(node)
	if visited(node) = false:
		ret.insert_at_the _front(node)
```

#### Time Complexity
O(V+E). The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.
#### Space Complexity
O(V). The extra space is needed for the stack.


# Problems
1. [Course Schedule](https://leetcode.com/problems/course-schedule/)
1. [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
1. [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)
1. [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/solution/)
1. [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)
1. [Sort Items by Groups Respecting Dependencies](https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/)

# References
* https://leetcode.com/discuss/interview-question/1409160/7.-Topological-Sorting
* https://leetcode.com/discuss/general-discussion/1078072/introduction-to-topological-sort
* https://www.geeksforgeeks.org/topological-sorting/
* https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
* https://leetcode.com/problems/course-schedule-ii/discuss/190393/Topological-Sort-Template-General-Approach!!/991601