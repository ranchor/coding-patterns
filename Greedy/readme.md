# Introduction
A greedy algorithm is an approach to solving problems where the best solution is chosen at each step with the hope of finding the global optimum. It builds up a solution piece by piece, always selecting the next piece that offers the most immediate benefit or value.

## When to Use Greedy Algorithms
Greedy algorithms are used when:
1. The problem has an optimal substructure (the optimal solution to the problem contains the optimal solutions to the subproblems).
2. The problem has the greedy-choice property (a global optimum can be reached by selecting the local optimums).

## Common Patterns in Greedy Algorithms

### Sorting
Sorting is often the first step in many greedy algorithms. By sorting the input data, we can make decisions based on the ordered elements.

### Using Heaps
Heaps (priority queues) are used to efficiently extract the minimum or maximum element. They are particularly useful in problems where we need to repeatedly select the largest or smallest remaining element.

### Interval Problems
Greedy algorithms are well-suited for interval problems. Common strategies include:
   - **Interval Scheduling**: Select intervals based on the earliest finish time.
   - **Minimum Platforms**: Manage overlapping intervals using two pointers or heaps.
   - **Activity Selection**: Similar to interval scheduling, select activities based on earliest finish time.

#### Interval Scheduling
Given a set of intervals, find the maximum number of non-overlapping intervals.

##### Approach
1. Sort intervals by their finishing times.
2. Select the interval that finishes first and remove all overlapping intervals.
3. Repeat until no intervals are left.

```java
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public int intervalScheduling(List<Interval> intervals) {
    Collections.sort(intervals, (a, b) -> a.end - b.end);
    int count = 0, end = Integer.MIN_VALUE;
    
    for (Interval interval : intervals) {
        if (interval.start >= end) {
            end = interval.end;
            count++;
        }
    }
    return count;
}
```

#### Minimum Platforms
Given the arrival and departure times of trains, find the minimum number of platforms required so that no train waits.

##### Approach
1. Sort both arrival and departure arrays.
2. Use two pointers to traverse both arrays and count platforms needed at a time.

```java
public int findPlatform(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int plat_needed = 1, result = 1;
    int i = 1, j = 0;

    while (i < n && j < n) {
        if (arr[i] <= dep[j]) {
            plat_needed++;
            i++;
        } else {
            plat_needed--;
            j++;
        }
        result = Math.max(result, plat_needed);
    }
    return result;
}
```

#### Activity Selection Problem
Select the maximum number of activities that don't overlap. Each activity has a start and end time.

##### Approach
1. Sort activities by their finishing times.
2. Always select the next activity whose start time is greater than or equal to the end time of the previously selected activity.


```java
class Activity {
    int start, end;
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public int activitySelection(List<Activity> activities) {
    Collections.sort(activities, (a, b) -> a.end - b.end);
    int count = 0, end = 0;
    
    for (Activity activity : activities) {
        if (activity.start >= end) {
            end = activity.end;
            count++;
        }
    }
    return count;
}
```

### Fractional Selection
In problems like the fractional knapsack, items can be divided to fit into a capacity constraint. Greedy algorithms sort items by a value-to-weight ratio and select the best fractional part.

#### Fractional Knapsack 
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

##### Approach
1. Calculate value per unit weight for each item.
2. Sort items by value-to-weight ratio.
3. Take the items with the highest ratio first until the knapsack is full.

```java
class Item {
    int weight;
    int value;
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public double fractionalKnapsack(int W, Item[] items) {
    Arrays.sort(items, (a, b) -> b.value / b.weight - a.value / a.weight);

    double totalValue = 0;
    for (Item item : items) {
        if (W >= item.weight) {
            W -= item.weight;
            totalValue += item.value;
        } else {
            totalValue += (double)item.value * W / item.weight;
            break;
        }
    }
    return totalValue;
}
```


### Job Scheduling
Job scheduling problems often involve deadlines and profits. The greedy approach usually involves sorting jobs by profit and using a timeline to track available slots.


#### Job Sequencing Problem
Given a set of jobs where each job has a deadline and profit associated, maximize the total profit if only one job can be scheduled at a time.

##### Approach
1. Sort jobs in decreasing order of profit.
2. For each job, find a free time slot before the deadline and schedule it.

```java
class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public int jobScheduling(Job[] jobs, int t) {
    Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

    boolean[] slot = new boolean[t];
    int profit = 0;

    for (Job job : jobs) {
        for (int j = Math.min(t, job.deadline) - 1; j >= 0; j--) {
            if (!slot[j]) {
                slot[j] = true;
                profit += job.profit;
                break;
            }
        }
    }
    return profit;
}
```
### Greedy Selection
Greedy selection involves making a series of decisions that seem locally optimal:
   - **Huffman Coding**: Build a binary tree where each node represents a character's frequency. Combine the two least frequent nodes at each step.
   - **Minimum Cost Problems**: Problems like connecting ropes (sticks) involve repeatedly combining the smallest elements to minimize the total cost.


#### Huffman Coding
Given frequencies of different characters, construct a Huffman Tree to minimize the total weighted path length of the tree.

##### Approach
1. Create a priority queue and insert all characters with their frequencies.
2. While there is more than one node in the queue, remove the two nodes with the highest priority (lowest frequency), combine them into a new node, and insert the new node back into the queue.
3. The remaining node is the root of the Huffman Tree.

```java
class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left, right;
    HuffmanNode(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
        this.left = this.right = null;
    }
}

public HuffmanNode buildHuffmanTree(char[] chars, int[] frequencies) {
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
    
    for (int i = 0; i < chars.length; i++) {
        pq.offer(new HuffmanNode(frequencies[i], chars[i]));
    }
    
    while (pq.size() > 1) {
        HuffmanNode left = pq.poll();
        HuffmanNode right = pq.poll();
        
        HuffmanNode newNode = new HuffmanNode(left.frequency + right.frequency, '-');
        newNode.left = left;
        newNode.right = right;
        
        pq.offer(newNode);
    }
    
    return pq.poll(); // Root of the Huffman Tree
}
```

### Graph-based Problems
In graph-related greedy problems, the aim is often to find the shortest path or minimum spanning tree.
   - **Prim's Algorithm**: Build the MST by repeatedly adding the smallest edge connecting the MST to a new vertex.
   - **Kruskal's Algorithm**: Build the MST by sorting edges and adding the smallest edge that doesn't form a cycle.
   - **Dijkstra's Algorithm**: Find the shortest path from a source vertex to all other vertices by selecting the vertex with the minimum distanc

#### Minimum Spanning Tree (Prim's Algorithm)
```java
public int primMST(int[][] graph) {
    int n = graph.length;
    int[] key = new int[n];
    Arrays.fill(key, Integer.MAX_VALUE);
    boolean[] inMST = new boolean[n];
    key[0] = 0;
    int result = 0;

    for (int count = 0; count < n - 1; count++) {
        int u = -1;
        for (int i = 0; i < n; i++) {
            if (!inMST[i] && (u == -1 || key[i] < key[u])) {
                u = i;
            }
        }
        
        inMST[u] = true;
        result += key[u];

        for (int v = 0; v < n; v++) {
            if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                key[v] = graph[u][v];
            }
        }
    }
    
    return result;
}
```

#### Dijkstra's Algorithm for Shortest Path
```java
public int[] dijkstra(int[][] graph, int src) {
    int n = graph.length;
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    boolean[] visited = new boolean[n];

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer

(new int[]{src, 0});

    while (!pq.isEmpty()) {
        int[] node = pq.poll();
        int u = node[0];

        if (visited[u]) continue;
        visited[u] = true;

        for (int v = 0; v < n; v++) {
            if (graph[u][v] != 0 && !visited[v] && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
                pq.offer(new int[]{v, dist[v]});
            }
        }
    }

    return dist;
}
```

# References
* https://medium.com/algorithms-and-leetcode/greedy-algorithm-explained-using-leetcode-problems-80d6fee071c4