
# Introduction
A graph is a data structure that consists of the following two components: 
1. A finite set of vertices also called as nodes. 
1. A finite set of ordered pair of the form (u, v) called as edge. The pair is ordered because (u, v) is not the same 
as (v, u) in case of a directed graph(di-graph). The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v. 
The edges may contain weight/value/cost.
## Types of Graph
#### Undirected graph
An undirected graph (graph) is a graph in which edges have no orientation. The edge (x, y) is identical to edge (y, x), 
i.e., they are not ordered pairs. The maximum number of edges possible in an undirected graph without a loop is n×(n-1)/2.

![](https://www.techiedelight.com/wp-content/uploads/2016/11/Undirected-Graph.png)
#### Directed graph
A Directed graph (digraph) is a graph in which edges have orientations, i.e., The edge (x, y) is not identical to edge (y, x)

![](https://www.techiedelight.com/wp-content/uploads/2016/11/Directed-Graph.png)
![](https://www.techiedelight.com/wp-content/uploads/2016/11/DAG.png)
#### Weighted and Unweighted graph
A weighted graph associates a value (weight) with every edge in the graph

![](https://www.techiedelight.com/wp-content/uploads/2016/11/Weighted-Directed-Graph.png)
#### Connected Graph
A Connected graph has a path between every pair of vertices. In other words, there are no unreachable vertices. 
A disconnected graph is a graph that is not connected.

![](https://www.techiedelight.com/wp-content/uploads/2016/11/Connected-graph.png)
#### Directed Acyclic Graph (DAG)
A Directed Acyclic Graph (DAG) is a directed graph that contains no cycles.
#### Bipartite Graph
A graph in which vertex can be divided into two sets such that vertex in each set does not contain any edge between them.

![](https://media.geeksforgeeks.org/wp-content/uploads/20200630122552/bipartite1.jpg)

## Graphs Representation
![](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/undirectedgraph.png)
### Adjacency Matrix
* An adjacency matrix is a square matrix used to represent a finite graph
* Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. 
Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j.
* Adjacency matrix for undirected graph is always symmetric
![](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/adjacencymatrix.png)
* ``adj[i][j] = 1``, when there is an edge from vertex i to vertex j, and
* ``adj[i][j] = 0``, when there is no edge.
* **Pros**
  * Representation is easier to implement and follow.
  * Removing an Edge O(1)
  * Query like (u,v) exits can take O(1) time .
* **Cons**
  * More space: O(V*V). For spare graph this will be more space
  * Adding a vertex is O(V*2)

### Adjacency List
* An adjacency list representation for the graph associates each vertex in the graph with the collection of its neighboring vertices or edges, 
i.e., every vertex stores a list of adjacent vertices.
* An array of lists is used. The size of the array is equal to the number of vertices
![](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/listadjacency.png)
* An entry array[i] represents the list of vertices adjacent to the ith vertex.
* **Pros**
  * Space Optimized. O(|v|+|e|) space only. 
  * Adding a vertex is easier
* **Cons**
  * Query like (u,v) exits can take O(V) time 
* For most applications, adjacency list are more efficient [2].
![](https://miro.medium.com/max/1400/1*sHYasThtSfMwi4K8naRxKQ.png)

## Graph Search or Traversals Techniques
### Depth-First Search(DFS)
The Depth–first search (DFS) algorithm starts at the root of the tree (or some arbitrary node for a graph) and explored as far as possible along each branch before backtracking.
* **Recursive Implementation of DFS**
    * A Depth–first search (DFS) is a way of traversing graphs closely related to the preorder traversal of a tree.
    * The only catch here is, unlike trees, graphs may contain cycles (a node may be visited twice). To avoid processing a node more than once, use a boolean visited array. 
    * **Time complexity:** ``O(V + E), where V is the number of vertices and E is the number of edges in the graph.``
    * **Space Complexity:** ``O(V), since an extra visited array of size V is required.``
* **Iterative Implementation of DFS**
    * The non-recursive implementation of DFS is similar to the non-recursive implementation of BFS but differs from it in two ways:
      * It uses a **stack** instead of a **queue.**
      * The DFS should mark visited only after popping the vertex, not before pushing it.
      * It uses a reverse iterator instead of an iterator to produce the same results as recursive DFS.
* **Applications of DFS**
    * Finding connected components in a graph.
    * Topological sorting in a DAG(Directed Acyclic Graph).
    * Finding 2/3–(edge or vertex)–connected components.
    * Finding the bridges of a graph.
    * Finding strongly connected components.
    * Solving puzzles with only one solution, such as mazes.
    * Finding biconnectivity in graphs
### Breadth First Search(BFS)
The Breadth–first search (BFS) algorithm also starts at the root of the tree (or some arbitrary node of a graph), but unlike DFS, it explores the neighbor nodes first, before moving to the next-level neighbors. 
In other words, BFS explores vertices in the order of their distance from the source vertex, where distance is the minimum length of a path from the source vertex to the node.
* **Implementation of BFS**
    * **[IMPORTANT]** Graph may contain cycles that's why we use logic of visited nodes concept. We implemented visitedNodes using boolean array.
    * BFS logic is not recursive and it uses queue. Key thing to remember is to use queue.
    * **Time Complexity:** ``O(V+E)`` where V is a number of vertices in the graph and E is a number of edges in the graph.
* **Applications of BFS**
    * Shortest Path and Minimum Spanning Tree for unweighted graph
    * In Garbage Collection: Breadth First Search is used in copying garbage collection using Cheney’s algorithm.
    * Peer to Peer Networks.
    * Crawlers in Search Engines
    * Social Networking Websites
    * GPS Navigation systems

# Patterns
## DFS
1. DFS from boundary
This variant is used to mark regions that are connected to the boundary of the grid.
    1. [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
    2. [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)
2. Shortest time
    1. [Time Needed to Inform All Employees](https://leetcode.com/problems/time-needed-to-inform-all-employees/)
3. Islands Variants
    1. [Number of Islands](https://leetcode.com/problems/number-of-islands/)
    2. [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
    3. [Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/)
    4. [Coloring A Border](https://leetcode.com/problems/coloring-a-border/)
    5. [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)
    6. [Robot Room Cleaner](https://leetcode.com/problems/robot-room-cleaner/)
    7. [Flood Fill](https://leetcode.com/problems/flood-fill/)
```java
int numIslands(char[][] grid) {
    int count = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1' && visited[i][j]==false) {
                count++;
                dfsExploreIsland(grid, visited, i, j);
            }
        }
    }
    return count;
}

void dfsExploreIsland(char[][] grid, boolean[][] visited, int row, int col) {
    if (outOfBounds(row, col) || grid[row][col] == '0' || visited[row][col]) return;
    
    // If you don't want to avoid extra space of using visited boolean array then you can modify the existing array.
    visited[row][col] = true; 
    
    // Explore neighbors
    dfsExploreIsland(grid, visited, row - 1, col);
    dfsExploreIsland(grid, visited, row + 1, col);
    dfsExploreIsland(grid, visited, row, col - 1);
    dfsExploreIsland(grid, visited, row, col + 1);

    /*
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] dir : dirs) {
        dfsExploreIsland(grid, row+dir[0], col+dir[1]);
    }
    */
}

boolean outOfBounds(char[][] grid, int row, int col) {
    return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
}
```
4. Hash/DFS
Use a combination of hashing and DFS to solve problems efficiently
    1. [Clone Graph](https://leetcode.com/problems/clone-graph/)
    2. [Employee Importance](https://leetcode.com/problems/employee-importance/)
    3. [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)
5. Cycle Find
    1. [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)


## BFS
This variant is commonly used to find the shortest path from a source node to a destination node in a graph or grid.
1. [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
2. [Walls and Gates](https://leetcode.com/problems/walls-and-gates/)
3. [01 Matrix](https://leetcode.com/problems/01-matrix/)
4. [As Far from Land as Possible](https://leetcode.com/problems/as-far-from-land-as-possible/)
5. [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
```java
import java.util.*;

public class BFS {
    public int bfsTemplate(int[][] grid, int startX, int startY, int targetX, int targetY) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == targetX && y == targetY) {
                    return level; // Target reached
                }

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (isValid(newX, newY, rows, cols) && !visited[newX][newY] && grid[newX][newY] != 0) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            level++;
        }

        return -1; // Target not reachable
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

```
**Please note the “breadth-first search” algorithm can only solve the “shortest path” problem in “unweighted graphs”**

## Graph Coloring/Bipartition Problems
1. [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)
2. [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)


## Single/Multi-source Shortest Path (Dijkstra's/Bellman Ford/Floyd-WarShall Algorithm)
* This variant involves finding the shortest path from a source node to all other nodes in a weighted graph.

### Dijkstra's Algorithm
Dijkstra's algorithm is used to find the shortest paths from a single source to all other nodes in a weighted graph with non-negative edge weights. It maintains a priority queue to select the node with the shortest distance at each step.
* Works for non-negative edge weights.
* Greedy approach by selecting the node with the shortest distance.
* Requires a **priority queue or min-heap** to select the node with the shortest distance at each step. 
* Best suited for finding single-source shortest paths.

```java
import java.util.*;

public class Solution {
    // Adjacency list to store edges and their respective travel times
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void dijkstra(int[] signalReceivedAt, int source, int n) {
        // Priority Queue to select the node with the shortest signal time
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparing(Pair::getKey)
        );
        pq.add(new Pair(0, source));

        // Initialize the signal time for the source node
        signalReceivedAt[source] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.poll();

            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();

            // Skip this node if we already found a shorter path to it
            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }

            // Skip this node if it has no outgoing edges
            if (!adj.containsKey(currNode)) {
                continue;
            }

            // Iterate through the edges and update signal times to neighbors
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();       // Travel time to the neighbor
                int neighborNode = edge.getValue(); // Neighbor node

                // Calculate the time when the signal reaches the neighbor node
                int signalTime = currNodeTime + time;

                // If the new signal time is shorter, update it and add to the queue
                if (signalReceivedAt[neighborNode] > signalTime) {
                    signalReceivedAt[neighborNode] = signalTime;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list from the input edges
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            // Initialize the adjacency list
            adj.putIfAbsent(source, new ArrayList<>());

            // Add the neighbor and travel time to the list
            adj.get(source).add(new Pair(travelTime, dest));
        }

        // Initialize an array to store the shortest signal times for each node
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        // Apply Dijkstra's algorithm to compute signal times
        dijkstra(signalReceivedAt, k, n);

        // Find the maximum signal time to get the network delay time
        int networkDelayTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            networkDelayTime = Math.max(networkDelayTime, signalReceivedAt[i]);
        }

        // If any node remains at its initial value, it's unreachable
        return (networkDelayTime == Integer.MAX_VALUE) ? -1 : networkDelayTime;
    }
}

```

#### Complexity Analysis
* Time complexity: ``O(E + V*log(V))`` with a priority queue, where E is the number of edges.
* Space complexity: ``O(E+V)`` with an array, where V is the number of vertices.



### Bellman Ford
The Bellman-Ford algorithm is used to find the shortest paths from a single source to all other nodes in a weighted graph, even if it contains negative weight edges. It detects negative weight cycles.
* Works for graphs with negative weight edges.
* Uses relaxation of edges iteratively.
* Detects negative weight cycles.
* Suitable for single-source shortest path when negative weights are present.

```java
import java.util.*;

public class Solution {
    // Helper class to represent edges
    class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Create a list to store edges
        List<Edge> edges = new ArrayList<>();
        
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            edges.add(new Edge(from, to, weight));
        }

        // Initialize the distance array to represent the shortest path from node k to all other nodes
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        // Relax edges repeatedly
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (distance[edge.from] != Integer.MAX_VALUE && distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distance[edge.from] != Integer.MAX_VALUE && distance[edge.to] > distance[edge.from] + edge.weight) {
                // Negative cycle found, return -1
                return -1;
            }
        }

        // Find the maximum distance, which is the answer
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}

```

#### Complexity Analysis

### Floyd Warshall
The Floyd-Warshall algorithm is used to find the shortest paths between all pairs of nodes in a weighted graph. It can handle both positive and negative weight edges but does not detect negative weight cycles.
* Works for all types of edge weights.
* Computes shortest paths between all pairs of nodes.
* Uses dynamic programming and a matrix to store distances.
* Doesn't detect negative weight cycles.
* Suitable for finding all pairs shortest paths.

#### Complexity Analysis


1. [Network Delay Time](https://leetcode.com/problems/network-delay-time/)
2. [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
3. https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/


## Union-Find Problems
1. [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
2. [Redundant Connection](https://leetcode.com/problems/redundant-connection/)
3. [Evaluate Division](https://leetcode.com/problems/evaluate-division/)
4. [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
5. [Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/)
6. [Accounts Merge](https://leetcode.com/problems/accounts-merge/)
7. [Most Stones Removed with Same Row or Column](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/)
8. [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
9. [Connecting Cities With Minimum Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)


## Topological Sort Problems
1. [Course Schedule](https://leetcode.com/problems/course-schedule/)
2. [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
3. [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)
4. [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/solution/)


## Connected components problems(Tarjan's Algorithm)
1. [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
2. [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
3. Critical Connections in a Network: https://leetcode.com/problems/critical-connections-in-a-network/


## Minimum Spanning Tree problems(Prim's and Kruskal's algorithm)
* [Connecting Cities With Minimum Cost](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)
* [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/)



# Problems



# References
* https://leetcode.com/discuss/general-discussion/655708/graph-for-beginners-problems-pattern-sample-solutions/
* https://leetcode.com/discuss/study-guide/1326900/graph-algorithms-problems-to-practice
* https://leetcode.com/discuss/interview-question/753236/List-of-graph-algorithms-for-coding-interview
* https://leetcode.com/discuss/general-discussion/969327/Graph-Algorithms-One-Place-or-Dijkstra-or-Bellman-Ford-or-Floyd-Warshall-or-Prims-or-Kruskals-or-DSU
* https://yunrui-li.medium.com/leetcode-graph-ff9c4e9e135f
* https://leetcode.com/explore/featured/card/graph/622/single-source-shortest-path-algorithm/3862/