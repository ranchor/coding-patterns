# Table of contents

- [Table of contents](#table-of-contents)
- [General Data Structure](#general-data-structure)
  - [Arrays](#arrays)
  - [Strings](#strings)
  - [HashMap](#hashmap)
  - [TreeMap](#treemap)
  - [HashSet](#hashset)
  - [ArrayList](#arraylist)
  - [Heap](#heap)
  - [Queue](#queue)
  - [Dequeue](#dequeue)
  - [Stack](#stack)
  - [LinkedList](#linkedlist)
- [StringBuilder && StringBuffer](#stringbuilder--stringbuffer)
- [Pair Class](#pair-class)
- [Math Utils](#math-utils)
- [Arrays Utils](#arrays-utils)
- [Character Utils](#character-utils)
- [Integer Utils](#integer-utils)
- [Collection Utils](#collection-utils)


# General Data Structure

## Arrays
| Operation | Code | Description | TC |
|---|---|---|---|
| **One Dimensional** | <pre lang="java">int[] myArr = new int[10];</pre> | Creates a one-dimensional array of integers with a length of 10. |  |
| **Two dimensional** | <pre lang="java">int[][] myArr = new int[10][20];</pre> | Creates a two-dimensional array of integers with dimensions 10x20. |  |
| **Array literals** | <pre lang="java">int[] myArr = new int[]{1, 2, 3};</pre> <pre lang="java">int[] myArr = {1, 2, 3};</pre> <pre lang="java">int[][] myArr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };</pre> | Initializes arrays with literal values. |  |
| **Accessing** | <pre lang="java">for (int i = 0; i < myArr.length; i++) { System.out.print(myArr[i]); }</pre> <pre lang="java">for (int[] row : myArr) { for (int element : row) { System.out.print(element); } }</pre> | Iterates through elements of the array using loops. |  |


## Strings
| Operation | Code | Description | TC |
|---|---|---|---|
| **Creation** | <pre lang="java">String test = new String("ok");</pre> | Creates a new String object using the constructor. |  |
| **String Literal** | <pre lang="java">String test = "ok";</pre> | Creates a String object using string literal, which is more efficient and recommended. |  |
| **Size** | <pre lang="java">test.length();</pre> | Returns the length of the string. |  |
| **Accessing** | <pre lang="java">char[] chArr = test.toCharArray();</pre><pre lang="java">for (char c : chArr) { System.out.print(c); }</pre> <pre lang="java">for (int i = 0; i < test.length(); i++) { System.out.print(test.charAt(i)); } </pre> | Converts the string to a character array and iterates through each character using both enhanced for loop and traditional for loop. |  |
| **charAt** | <pre lang="java">test.charAt(index);</pre> | Returns the character at the specified index in the string. | O(1) |
| **compareTo** | <pre lang="java">test.compareTo("anotherString");</pre> | Compares two strings lexicographically. Returns a negative integer, zero, or a positive integer as the string is less than, equal to, or greater than the specified string. |  |
| **contains** | <pre lang="java">test.contains("substring");</pre> | Checks if the string contains the specified substring. |  |
| **indexOf** | <pre lang="java">test.indexOf("substring");</pre> | Returns the index of the first occurrence of the specified substring within the string, or -1 if not found. |  |
| **substring** | <pre lang="java">test.substring(startIndex, endIndex);</pre> | Returns a substring of the string starting from the specified startIndex (inclusive) to the endIndex (exclusive). |  |
| **startsWith** | <pre lang="java">test.startsWith("prefix");</pre> | Checks if the string starts with the specified prefix. |  |
| **endsWith** | <pre lang="java">test.endsWith("suffix");</pre> | Checks if the string ends with the specified suffix. |  |
| **toUpperCase** | <pre lang="java">test.toUpperCase();</pre> | Returns a new string with all characters converted to uppercase. |  |
| **toLowerCase** | <pre lang="java">test.toLowerCase();</pre> | Returns a new string with all characters converted to lowercase. |  |
| **trim** | <pre lang="java">test.trim();</pre> | Returns a new string with leading and trailing whitespace removed. |  |
| **split** | <pre lang="java">String[] parts = test.split("regex");</pre> | Splits the string into an array of substrings based on the specified regular expression. |  |



## HashMap
A data structure that maps keys to values. A map cannot contain duplicate keys and each key can map to at most one value.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.HashMap;</pre> | Importing the required HashMap class. |  |
| **Creation (diff types)** | <pre lang="java">HashMap hm = new HashMap<>();</pre> | Creates a new HashMap object. |  |
| **Add Element** | <pre lang="java">hm.put("gopha", "ok");</pre> | Adds an element to the HashMap with the specified key and value. | O(1) |
| **Update Element** | <pre lang="java">hm.put("gopha", hm.getOrDefault("gopha", "newvalue"));</pre> | Attempts to retrieve the value for the key "gopha". If not present, "newvalue" will be used instead and saved for the respective key of "gopha". | O(1) |
| **Remove element** | <pre lang="java">hm.remove("gopha");</pre> | Removes the entry with the specified key from the HashMap. | O(1) |
| **Search Element** | <pre lang="java">hm.containsKey("gopha");</pre><pre lang="java">hm.containsValue("ok");</pre> | Checks if the HashMap contains the specified key or value. | O(1) |
| **Size** | <pre lang="java">hm.size();</pre> | Returns the number of key-value mappings in this HashMap. |  |
| **Accessing** | <pre lang="java">for (Map.Entry entry : hm.entrySet())</pre><pre lang="java">{ System.out.println(entry.getKey() + " " + entry.getValue()); <br>}</pre><pre lang="java">for (String key : hm.keySet()) { System.out.println(key); }</pre><pre lang="java">for (String value : hm.values()) { System.out.println(value); }</pre> | Accesses the elements of the HashMap using various methods such as iterating over entries, keys, or values. |  |


## TreeMap
A Red-Black tree-based NavigableMap implementation. It is sorted according to the natural ordering of its keys, or by a Comparator provided at the time of creation.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.TreeMap;</pre> | Importing the required TreeMap class. |  |
| **Creation** | <pre lang="java">TreeMap<Integer, String> treeMap = new TreeMap<>();</pre> | Creates a new TreeMap object with keys sorted in natural order. |  |
| **Add Element** | <pre lang="java">treeMap.put(1, "apple");</pre> | Adds an element to the TreeMap with the specified key and value. | O(log n) |
| **Remove element** | <pre lang="java">treeMap.remove(1);</pre> | Removes the entry with the specified key from the TreeMap. | O(log n) |
| **Search Element** | <pre lang="java">treeMap.containsKey(1);</pre> <pre lang="java">treeMap.containsValue("apple");</pre> | Checks if the TreeMap contains the specified key or value. | O(log n) |
| **Size** | <pre lang="java">treeMap.size();</pre> | Returns the number of key-value mappings in this TreeMap. | O(1) |
| **Accessing** | <pre lang="java">treeMap.get(1);</pre> | Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key. | O(log n) |
| **Navigable Operations** | <pre lang="java">treeMap.firstEntry();</pre> <pre lang="java">treeMap.lastEntry();</pre> <pre lang="java">treeMap.ceilingEntry(5);</pre> <pre lang="java">treeMap.floorEntry(5);</pre> | Provides navigational operations for retrieval based on keys. |  |



## HashSet
A collection that uses a Hash table for storage, only allowing unique elements to be added.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.HashSet;</pre> | Importing the required HashSet class. |  |
| **Creation** | <pre lang="java">HashSet<String> hs = new HashSet<>();</pre> | Creates a new HashSet object. |  |
| **Add Element** | <pre lang="java">hs.add("gopha ok");</pre> | Adds an element to the HashSet. | O(1) |
| **Remove Element** | <pre lang="java">hs.remove("gopha ok");</pre> | Removes the specified element from the HashSet. | O(1) |
| **Search element** | <pre lang="java">hs.contains("gopha ok");</pre> | Checks if the HashSet contains the specified element. | O(1) |
| **Size** | <pre lang="java">hs.size();</pre> | Returns the number of elements in the HashSet. | O(1) |
| **Accessing** | <pre lang="java">for (String s : hs) { System.out.println(s); }</pre> | Iterates through the elements of the HashSet. |  |




## ArrayList
A collection of data elements sequentially ordered from 0 to length - 1. This means that we are able to access an element inside an ArrayList by its position (index).

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.ArrayList;</pre> | Importing the required ArrayList class. |  |
| **Creation** | <pre lang="java">ArrayList<Integer> list = new ArrayList<>();</pre><br><pre lang="java">List<Integer> list = new ArrayList<>();</pre> | Creates a new ArrayList object. |  |
| **Add Element** | <pre lang="java">list.add(1);</pre> | Adds an element to the end of the list. | O(1) |
| **Add Element at Start** | <pre lang="java">list.add(0, yourObject);</pre> | Inserts the specified element at the specified position in this list. | O(n) |
| **Update Element** | <pre lang="java">list.set(0, 100);</pre> | Updates the element at the specified index with the given value. | O(1) |
| **Remove Element** | <pre lang="java">list.remove(0);</pre><pre lang="java">list.clear();</pre> | Removes the element at the specified index or removes all elements from the list. | O(n) |
| **Remove Last Element in List** | <pre lang="java">List<Integer> temp = new ArrayList<>();</pre><pre lang="java">index=temp.size()-1; temp.remove(index);</pre> | Removes the last element from the list. | O(1) |
| **Size** | <pre lang="java">list.size();</pre> | Returns the number of elements in the list. | O(1) |
| **Accessing** | <pre lang="java">for (int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }</pre><pre lang="java">for (String s : list) { System.out.println(s); }</pre> | Iterates through the elements of the list using both traditional and enhanced for loop. | O(n) |
| **Sorting** | <pre lang="java">import java.util.Collections;</pre><pre lang="java">Collections.sort(list);</pre><pre lang="java">Collections.sort(list, Collections.reverseOrder());</pre> | Sorts the elements of the list in ascending or descending order. | O(n log n) |
| **Convert to Array** | <pre lang="java">T[] arr = list.toArray(new T[0]);</pre> | Converts the list to an array. | O(n) |



## LinkedList
A linear collection of data elements, called nodes, each pointing to the next node by means of a pointer. It is a data structure consisting of a group of nodes which together represent a sequence. 

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.LinkedList;</pre> | Importing the required LinkedList class. |  |
| **Creation** | <pre lang="java">LinkedList<Integer> list = new LinkedList<>();</pre><pre lang="java">LinkedList<Integer> ll = new LinkedList(C);</pre> | Creates a new LinkedList instance, either empty or containing elements from a specified collection. |  |
| **Insert Element** | <pre lang="java">list.add(1);</pre>  | Inserts an element at the end of the linked list. | O(1) |
| **Update Element** | <pre lang="java">list.set(0, 100);</pre> | Updates the element at the specified index with the given value. | O(1) |
| **Remove Element** | <pre lang="java">list.remove(0);</pre><pre lang="java">list.remove(1);</pre><pre lang="java">list.clear();</pre> | Removes elements from the linked list: by index, by element, or all elements. | O(1) |
| **Size** | <pre lang="java">list.size();</pre>  | Returns the number of elements in the linked list. | O(1) |
| **Accessing** |  <pre lang="java">for (int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }</pre><pre lang="java">for (int i : list) { System.out.println(s); }</pre>   | Accesses elements of the linked list using a loop. | O(n) |
| **Get Last Element** | <pre lang="java">list.getLast();</pre> | Returns the last element in the linked list. | O(1) |
| **Get First Element** | <pre lang="java">list.getFirst();</pre> | Returns the first element in the linked list. | O(1) |



## Heap
A specialized tree-based data structure that satisfies the heap property: if A is a parent node of B, then the key (the value) of node A is ordered with respect to the key of node B with the same ordering applying across the entire heap. A heap can be classified further as either a "max heap" or a "min heap". In a max heap, the keys of parent nodes are always greater than or equal to those of the children, and the highest key is in the root node. In a min heap, the keys of parent nodes are less than or equal to those of the children, and the lowest key is in the root node. 

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.PriorityQueue;</pre> | Importing the required PriorityQueue class. |  |
| **Creation** | <pre lang="java">PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder);</pre><pre lang="java">PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(</pre><pre lang="java">(a, b) -> a.getValue().equals(b.getValue()) ?</pre><pre lang="java">a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue() );</pre> | Creates a PriorityQueue with specified initial capacity and comparator. | O(n) |
| **Add Element** | <pre lang="java">pq.add(10);</pre> | Adds an element to the priority queue. | O(log n) |
| **View Top Element** | <pre lang="java">pq.peek();</pre> | Returns but does not remove the top element from the priority queue. | O(1) |
| **Remove Element** | <pre lang="java">pq.poll();</pre> | Returns and removes the top element from the priority queue. | O(log n) |
| **Size** | <pre lang="java">pq.size();</pre> | Returns the number of elements in the priority queue. | O(1) |
| **Accessing** |  |  |  |




## Queue
A collection of elements, supporting two principle operations: enqueue, which inserts an element into the queue, and dequeue, which removes an element from the queue.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.Queue;</pre> | Importing the required Queue interface. |  |
| **Creation** | <pre lang="java">Queue<Integer> q = new LinkedList<>();</pre> | Creates a new Queue instance using LinkedList. |  |
| **Add Element** | <pre lang="java">q.add(10);</pre><pre lang="java">boolean success = q.offer(10);</pre> | Adds an element to the queue. Returns true on successful insertion else it returns false. | O(1) |
| **View Top Element** | <pre lang="java">q.peek();</pre> | Returns the head of the queue, or null if the queue is empty. | O(1) |
| **Remove Element** | <pre lang="java">q.poll();</pre> | Removes and returns the head of the queue, or null if the queue is empty. | O(1) |
| **Size** | <pre lang="java">q.size();</pre><pre lang="java">q.isEmpty();</pre> | Returns the number of elements in the queue. Returns true if the queue is empty. | O(1) |
| **Accessing** |  |  |  |

## Dequeue
A double-ended queue (pronounced "deck") that supports insertion and removal of elements from both ends.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.Deque;</pre> | Importing the required Deque interface. |  |
| **Creation** | <pre lang="java">Deque<Integer> deque = new LinkedList<>();</pre> | Creates a new Deque instance using LinkedList. |  |
| **Add Element at Front** | <pre lang="java">deque.addFirst(10);</pre> | Inserts the specified element at the front of the deque. | O(1) |
| **Add Element at End** | <pre lang="java">deque.addLast(20);</pre> | Inserts the specified element at the end of the deque. | O(1) |
| **View First Element** | <pre lang="java">deque.peekFirst();</pre> | Retrieves, but does not remove, the first element of the deque, or returns null if the deque is empty. | O(1) |
| **View Last Element** | <pre lang="java">deque.peekLast();</pre> | Retrieves, but does not remove, the last element of the deque, or returns null if the deque is empty. | O(1) |
| **Remove First Element** | <pre lang="java">deque.pollFirst();</pre> | Retrieves and removes the first element of the deque, or returns null if the deque is empty. | O(1) |
| **Remove Last Element** | <pre lang="java">deque.pollLast();</pre> | Retrieves and removes the last element of the deque, or returns null if the deque is empty. | O(1) |
| **Size** | <pre lang="java">deque.size();</pre><pre lang="java">deque.isEmpty();</pre> | Returns the number of elements in the deque. Returns true if the deque is empty. | O(1) |







## Stack
A collection of elements, with two principle operations: push, which adds to the collection, and pop, which removes the most recently added element.

| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import java.util.Stack;</pre> | Importing the required Stack class. |  |
| **Creation** | <pre lang="java">Stack<Integer> st = new Stack<>();</pre> | Creates a new Stack object. |  |
| **Insert Element** | <pre lang="java">st.push(10);</pre> | Inserts an element onto the top of the stack. | O(1) |
| **View Top Element** | <pre lang="java">st.peek();</pre> | Returns the top element of the stack without removing it. | O(1) |
| **Remove Element** | <pre lang="java">st.pop();</pre> | Removes the top element from the stack and returns it. | O(1) |
| **Size** | <pre lang="java">st.size();</pre><pre lang="java">st.isEmpty();</pre> | Returns the number of elements in the stack. Returns true if the stack is empty. | O(1) |
| **Accessing** |  |  |  |






# StringBuilder && StringBuffer

### Difference

| Aspect           | StringBuilder                                | StringBuffer                              |
|------------------|----------------------------------------------|-------------------------------------------|
| Mutability       | Mutable                                      | Mutable                                   |
| Thread Safety    | Not thread-safe                              | Thread-safe                               |
| Performance      | Typically faster                             | Slightly slower due to synchronization   |
| Usability        | Preferred in single-threaded environments    | Preferred in multithreaded environments   |
| Introduced in    | Java 5                                       | Early versions of Java                    |
| Compatibility    | Part of Java Collections Framework           | Available for compatibility reasons      |
| Methods          | Identical methods and behavior               | Identical methods and behavior            |



### Operations


| Operation | Code | Description | TC |
|---|---|---|---|
| **Creation** | <pre lang="java">StringBuilder sb = new StringBuilder();</pre><pre lang="java">StringBuffer sbf = new StringBuffer();</pre> | Creates a new instance of StringBuilder and StringBuffer respectively. |  |
| **Append** | <pre lang="java">sb.append("hello");</pre><pre lang="java">sbf.append("world");</pre> | Appends the specified string representation to the end of the sequence. | O(1) |
| **Insert** | <pre lang="java">sb.insert(0, "java");</pre><pre lang="java">sbf.insert(0, "hello");</pre> | Inserts the specified string representation at the specified position. | O(n) |
| **Replace** | <pre lang="java">sb.replace(0, 2, "hi");</pre><pre lang="java">sbf.replace(0, 2, "hi");</pre> | Replaces the characters in a substring of the sequence with characters in the specified string. | O(n) |
| **Delete** | <pre lang="java">sb.delete(0, 2);</pre><pre lang="java">sbf.delete(0, 2);</pre> | Removes the characters in a substring of this sequence. | O(n) |
| **Reverse** | <pre lang="java">sb.reverse();</pre><pre lang="java">sbf.reverse();</pre> | Causes this character sequence to be replaced by the reverse of the sequence. | O(n) |
| **Get Length** | <pre lang="java">sb.length();</pre><pre lang="java">sbf.length();</pre> | Returns the length (number of characters) of the character sequence. | O(1) |
| **Convert to String** | <pre lang="java">sb.toString();</pre><pre lang="java">sbf.toString();</pre> | Returns a string representing the data in the sequence. | O(n) |



# Pair Class
| Operation | Code | Description | TC |
|---|---|---|---|
| **Import required** | <pre lang="java">import javafx.util.Pair;</pre> | Importing the required Pair class. |  |
| **Pair Class** | <pre lang="java">Pair<Integer, String> pair = new Pair<>(1, "one");</pre> | Represents a generic pair of two objects. |  |
| **Get First Item** | <pre lang="java">pair.getKey();</pre> | Returns the first item of the pair. | O(1) |
| **Get Second Item** | <pre lang="java">pair.getValue();</pre> | Returns the second item of the pair. | O(1) |



# Math Utils
| Method Signature                                | Description                                                                                      | Example                                                     |
|-------------------------------------------------|--------------------------------------------------------------------------------------------------|-------------------------------------------------------------|
| `Math.max(int a, int b)`                        | Returns the maximum of two integers.                                                             | `int result = Math.max(5, 8);`                              |
| `Math.min(int a, int b)`                        | Returns the minimum of two integers.                                                             | `int result = Math.min(5, 8);`                              |
| `Math.abs(int x)`                              | Returns the absolute value of an integer.                                                        | `int result = Math.abs(-5);`                                |
| `Math.pow(double a, double b)`                  | Returns the value of the first argument raised to the power of the second argument.              | `double result = Math.pow(2, 3);`                           |
| `Math.sqrt(double x)`                          | Returns the positive square root of a double value.                                               | `double result = Math.sqrt(25);`                            |
| `Math.ceil(double a)`                          | Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer. | `double result = Math.ceil(4.3);`                      |
| `Math.floor(double a)`                         | Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer. | `double result = Math.floor(4.9);`                     |
| `Math.round(float a)`                         | Returns the closest integer to the argument, with ties rounding to positive infinity.           | `long result = Math.round(4.5);`                            |
| `Math.random()`                                | Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.     | `double result = Math.random();`                            |



# Arrays Utils
| Method Signature                             | Description                                                                                   | Example                                                                     |
|----------------------------------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| `Arrays.sort(T[] arr)`                       | Sorts the specified array of objects into ascending order.                                   | `int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};`<br>`Arrays.sort(arr);`            |
| `Arrays.asList(T... arr)`                   | Returns a fixed-size list backed by the specified array.                                      | `String[] arr = {"apple", "banana", "cherry"};`<br>`List<String> list = Arrays.asList(arr);` |
| `Arrays.fill(T[] arr, T val)`               | Assigns the specified value to each element of the specified array.                          | `int[] arr = new int[5];`<br>`Arrays.fill(arr, 7);`                        |
| `Arrays.equals(T[] arr1, T[] arr2)`         | Returns `true` if the two specified arrays of objects are equal to one another.              | `int[] arr1 = {1, 2, 3};`<br>`int[] arr2 = {1, 2, 3};`<br>`boolean isEqual = Arrays.equals(arr1, arr2);` |
| `Arrays.copyOf(T[] original, int newLength)` | Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length. | `int[] arr = {1, 2, 3};`<br>`int[] newArr = Arrays.copyOf(arr, 5);`       |
| `Arrays.toString(T[] arr)`                  | Returns a string representation of the contents of the specified array.                         | `int[] arr = {1, 2, 3};`<br>`String str = Arrays.toString(arr);`          |


# Character Utils
| Method Signature                                   | Description                                                                                                   | Example                                                                      |
|----------------------------------------------------|---------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| `Character.isLetter(char ch)`                     | Determines if the specified character is a letter.                                                            | `char ch = 'A';`<br>`boolean isLetter = Character.isLetter(ch);`             |
| `Character.isDigit(char ch)`                      | Determines if the specified character is a digit.                                                             | `char ch = '5';`<br>`boolean isDigit = Character.isDigit(ch);`               |
| `Character.isWhitespace(char ch)`                 | Determines if the specified character is white space.                                                         | `char ch = ' ';`<br>`boolean isWhitespace = Character.isWhitespace(ch);`     |
| `Character.isUpperCase(char ch)`                  | Determines if the specified character is an uppercase letter.                                                 | `char ch = 'A';`<br>`boolean isUpperCase = Character.isUpperCase(ch);`       |
| `Character.isLowerCase(char ch)`                  | Determines if the specified character is a lowercase letter.                                                  | `char ch = 'a';`<br>`boolean isLowerCase = Character.isLowerCase(ch);`       |
| `Character.isLetterOrDigit(char ch)`              | Determines if the specified character is a letter or digit.                                                   | `char ch = '7';`<br>`boolean isLetterOrDigit = Character.isLetterOrDigit(ch);`|
| `Character.toUpperCase(char ch)`                 | Converts the specified character to uppercase.                                                                | `char ch = 'a';`<br>`char upperCaseCh = Character.toUpperCase(ch);`          |
| `Character.toLowerCase(char ch)`                 | Converts the specified character to lowercase.                                                                | `char ch = 'A';`<br>`char lowerCaseCh = Character.toLowerCase(ch);`          |
| `Character.compare(char x, char y)`              | Compares two `char` values numerically.                                                                       | `char x = 'A';`<br>`char y = 'B';`<br>`int result = Character.compare(x, y);` |
| `Character.digit(char ch, int radix)`            | Returns the numeric value of the specified character (for radix up to 36). Returns -1 if the character is not a digit. | `char ch = '7';`<br>`int digitValue = Character.digit(ch, 10);`             |


# Integer Utils
| Method Signature                                   | Description                                                                                                    | Example                                                                      |
|----------------------------------------------------|----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| `Integer.parseInt(String s)`                      | Parses the string argument as a signed decimal integer.                                                       | `String str = "123";`<br>`int num = Integer.parseInt(str);`                  |
| `Integer.valueOf(int i)`                          | Returns an Integer instance representing the specified int value.                                             | `int num = 123;`<br>`Integer integer = Integer.valueOf(num);`                 |

# Collection Utils
| Method Signature                                     | Description                                                                                                                | Example                                                                        |
|------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| `Collections.sort(List<T> list)`                     | Sorts the specified list into ascending order, according to the natural ordering of its elements.                         | `List<Integer> numbers = Arrays.asList(3, 1, 2);`<br>`Collections.sort(numbers);`|
| `Collections.sort(List<T> list, Comparator<? super T> c)` | Sorts the specified list according to the order induced by the specified comparator.                                       | `List<String> strings = Arrays.asList("banana", "apple", "orange");`<br>`Collections.sort(strings, Comparator.reverseOrder());` |






