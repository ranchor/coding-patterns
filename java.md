
# Table of contents

- [General Data Structure](#general-data-structure)
  - [Arrays](#arrays)
  - [Strings](#strings)
  - [HashMap](#hashmap)
  - [HashSet](#hashset)
  - [ArrayList](#arraylist)
  - [Heap](#heap)
  - [Queue](#queue)
  - [Stack](#stack)
  - [LinkedList](#linkedlist)
- [Math Utils](#math-utils)
- [Arrays Utils](#arrays-utils)
- [Character Utils](#character-utils)

# General Data Structure

## Arrays
| Operation | Code | TC |
|---|---|---|
| **One Dimensional** | <pre lang="java"> int[] myArr = new int[10]; </pre> |  |
| **Two dimensional** | <pre lang="java"> int[][] myArr = new int[10][20];</pre> |  |
| **Array literals** | <pre lang="java"> int[] myArr = new int[]{1, 2, 3}; </pre> <pre lang="java"> int[] myArr = {1, 2, 3}; </pre> <pre lang="java"> int[][] myArr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }; </pre> |  |
| **Accessing** | <pre lang="java"> for (int i = 0; i < myArr.length; i++) { System.out.print(myArr[i]); } </pre> <pre lang="java"> for (int[] row : myArr) { for (int element : row) { System.out.print(element); } } </pre>  |  |


## Strings
| Operation | Code | TC | Description |
|---|---|---|---|
| **Creation** | <pre lang="java">String test = new String("ok");</pre> |  | Creates a new String object using the constructor. |
| **String Literal** | <pre lang="java">String test = "ok";</pre> |  | Creates a String object using string literal, which is more efficient and recommended. |
| **Size** | <pre lang="java">test.length();</pre> |  | Returns the length of the string. |
| **Accessing** | <pre lang="java">char[] chArr = test.toCharArray();</pre><pre lang="java">for (char c : chArr) { System.out.print(c); }</pre> <pre lang="java">for (int i = 0; i < test.length(); i++) { System.out.print(test.charAt(i)); } </pre> |  | Converts the string to a character array and iterates through each character using both enhanced for loop and traditional for loop. |
| **charAt** | <pre lang="java">test.charAt(index);</pre> | O(1) | Returns the character at the specified index in the string. |
| **compareTo** | <pre lang="java">test.compareTo("anotherString");</pre> |  | Compares two strings lexicographically. Returns a negative integer, zero, or a positive integer as the string is less than, equal to, or greater than the specified string. |
| **contains** | <pre lang="java">test.contains("substring");</pre> |  | Checks if the string contains the specified substring. |
| **indexOf** | <pre lang="java">test.indexOf("substring");</pre> |  | Returns the index of the first occurrence of the specified substring within the string, or -1 if not found. |
| **substring** | <pre lang="java">test.substring(startIndex, endIndex);</pre> |  | Returns a substring of the string starting from the specified startIndex (inclusive) to the endIndex (exclusive). |
| **startsWith** | <pre lang="java">test.startsWith("prefix");</pre> |  | Checks if the string starts with the specified prefix. |
| **endsWith** | <pre lang="java">test.endsWith("suffix");</pre> |  | Checks if the string ends with the specified suffix. |
| **toUpperCase** | <pre lang="java">test.toUpperCase();</pre> |  | Returns a new string with all characters converted to uppercase. |
| **toLowerCase** | <pre lang="java">test.toLowerCase();</pre> |  | Returns a new string with all characters converted to lowercase. |
| **trim** | <pre lang="java">test.trim();</pre> |  | Returns a new string with leading and trailing whitespace removed. |
| **split** | <pre lang="java">String[] parts = test.split("regex");</pre> |  | Splits the string into an array of substrings based on the specified regular expression. |




## HashMap
A data structure that maps keys to values. A map cannot contain duplicate keys and each key can map to at most one value.

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">``import java.util.HashMap;``</pre> |  |
| **Creation (diff types)** | <pre lang="java">``HashMap hm = new HashMap<>();``</pre> |  |
| **Add Element** | <pre lang="java">``hm.put("gopha", "ok");`` // Key is "gopha", value is "ok"</pre> | O(1) |
| **Update Element** | <pre lang="java">``hm.put("gopha", hm.getOrDefault("gopha", "newvalue"));``</pre> <pre lang="java">``/** Note: Attempts to retrieve the value for the key "gopha". If not present,"newvalue" will be used instead and saved for the respective key of "gopha"**/``</pre> | O(1) |
| **Remove element** | <pre lang="java">``hm.remove("gopha");``</pre> <pre lang="java"> // Specify key to remove the entire entry</pre> | O(1) |
| **Search Element** | <pre lang="java">``hm.containsKey("gopha");``</pre> <pre lang="java"> //Returns boolean true if the presence of the key is detected else false. <br>``hm.containsValue("ok");`` //Returns true if this map maps one or more keys to the specified value.</pre> | O(1) |
| **Size** | <pre lang="java">hm.size();</pre> |  |
| **Accessing** | <pre lang="java">for (Map.Entry entry : hm.entrySet()) {System.out.println(entry.getKey() + " " + entry.getValue());}</pre> <pre lang="java"> for (String key : hm.keySet()) { System.out.println(key);  }</pre> <pre lang="java"> for (String value : hm.values()) { System.out.println(value); }</pre> <br> |  |

## HashSet
A collection that uses a Hash table for storage, only allowing unique elements to be added.

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">import java.util.HashSet;</pre> |  |
| **Creation** | <pre lang="java">HashSet<String> hs = new HashSet<>();</pre> |  |
| **Add Element** | <pre lang="java">hs.add("gopha ok");</pre> | O(1) |
| **Remove Element** | <pre lang="java">hs.remove("gopha ok");</pre> | O(1) |
| **Search element** | <pre lang="java">hs.contains("gopha ok");</pre> | O(1) |
| **Size** | <pre lang="java">hs.size();</pre> | O(1) |
| **Accessing** | <pre lang="java">for (String s : hs) { System.out.println(s); }</pre> | 



## ArrayList
A collection of data elements sequentially ordered from 0 to length - 1. This means that we are able to access an element inside an ArrayList by its position (index).

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">import java.util.ArrayList;</pre> |  |
| **Creation** | <pre lang="java">ArrayList<Integer> list = new ArrayList<>();</pre><br><pre lang="java">List<Integer> list = new ArrayList<>();</pre> |  |
| **Add Element** | <pre lang="java">list.add(1);</pre> | O(1) |
| **Add Element at Start** | <pre lang="java">list.add(0, yourObject);</pre><pre lang="java">// Inserts the specified element at the specified position in this list.</pre> | O(n) |
| **Update Element** | <pre lang="java">list.set(0, 100); // Update index 0's value to 100</pre> | O(1) |
| **Remove Element** | <pre lang="java">list.remove(0); // Remove index 0</pre><pre lang="java">list.clear(); // Remove all elements</pre> | O(n) |
| **Remove Last Element in List** | <pre lang="java">List<Integer> temp = new ArrayList<>();</pre><pre lang="java">index=temp.size()-1; temp.remove(index);</pre> | O(1) |
| **Size** | <pre lang="java">list.size();</pre> | O(1) |
| **Accessing** | <pre lang="java">for (int i = 0; i < list.size(); i++) {<br>    System.out.println(list.get(i));<br>}</pre><pre lang="java">for (String s : list) {<br>    System.out.println(s);<br>} </pre> | O(n) |
| **Sorting** | <pre lang="java">import java.util.Collections;</pre><pre lang="java">Collections.sort(list); // Sort ascending</pre><pre lang="java">Collections.sort(list, Collections.reverseOrder()); // Sort descending</pre> | O(n log n) |





## Heap
A specialized tree-based data structure that satisfies the heap property: if A is a parent node of B, then the key (the value) of node A is ordered with respect to the key of node B with the same ordering applying across the entire heap. A heap can be classified further as either a "max heap" or a "min heap". In a max heap, the keys of parent nodes are always greater than or equal to those of the children, and the highest key is in the root node. In a min heap, the keys of parent nodes are less than or equal to those of the children, and the lowest key is in the root node. 

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">``import java.util.PriorityQueue;``</pre> |  |
| **Creation** | <pre lang="java">``PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder);`` // Max heap </pre><pre lang="java">PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>( (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue() );</pre><pre lang="java">// Max heap that contains pairs - if values for pairs are the same, then they will be sorted ascending (a-z) according to key </pre> | O(n) |
| **Add Element** | <pre lang="java"> ``pq.add(10);`` </pre> | O(log n) |
| **View Top Element** | <pre lang="java"> ``pq.peek();`` // Returns but does not remove the top element </pre> | O(1) |
| **Remove Element** | <pre lang="java"> ``pq.poll();`` // Returns and removes the top element </pre> | O(log n) |
| **Size** | <pre lang="java"> ``pq.size();`` </pre> | O(1) |
| **Accessing** |  |  |


## Queue
A collection of elements, supporting two principle operations: enqueue, which inserts an element into the queue, and dequeue, which removes an element from the queue.

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">import java.util.Queue;</pre> |  |
| **Creation** | <pre lang="java">Queue<Integer> q = new LinkedList<>(); // Specify as a LinkedList</pre> |  |
| **Add Element** | <pre lang="java">q.add(10);boolean success = q.offer(10);  // Returns true on successful insertion else it returns false.</pre> | O(1) |
| **View Top Element** | <pre lang="java">q.peek(); // Returns head or null if empty</pre> | O(1) |
| **Remove Element** | <pre lang="java">q.poll(); // After removing returns head or null if empty</pre>  | O(1) |
| **Size** | <pre lang="java">q.size(); q.isEmpty(); // Returns true if the queue is empty</pre> | O(1) |
| **Accessing** |  |  |





## Stack
A collection of elements, with two principle operations: push, which adds to the collection, and pop, which removes the most recently added element.

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">import java.util.Stack;</pre> |  |
| **Creation** | <pre lang="java">Stack<Integer> st = new Stack<>();</pre> |  |
| **Insert Element** | <pre lang="java">st.push(10);</pre> | O(1) |
| **View Top Element** | <pre lang="java">st.peek();</pre> // Returns but does not remove the top element | O(1) |
| **Remove Element** | <pre lang="java">st.pop();</pre> // Returns and removes the top element | O(1) |
| **Size** | <pre lang="java">st.size();</pre><pre lang="java">st.isEmpty();</pre> // Returns true if the stack is empty | O(1) |
| **Accessing** |   |  |



## LinkedList
A linear collection of data elements, called nodes, each pointing to the next node by means of a pointer. It is a data structure consisting of a group of nodes which together represent a sequence. 

| Operation | Code | TC |
|---|---|---|
| **Import required** | <pre lang="java">import java.util.LinkedList;</pre> |  |
| **Creation** | <pre lang="java">LinkedList<Integer> list = new LinkedList<>();</pre> *// create an empty linked list*<br> `<pre lang="java">LinkedList<Integer> ll = new LinkedList(C);</pre>` *//create an ordered list that contains all the elements of a specified collection,* |  |
| **Insert Element** | <pre lang="java">list.add(1);</pre>  | O(1) |
| **Update Element** | <pre lang="java">list.set(0, 100);</pre> // Update index 0's value to 100  | O(1) |
| **Remove Element** | <pre lang="java">list.remove(0);</pre> // Remove index 0  <br><pre lang="java">list.remove(1);</pre> // remove Element 1 <br> <pre lang="java">list.clear();</pre> // Remove all elements  | O(1) |
| **Size** | <pre lang="java">list.size();</pre>  | O(1) |
| **Accessing** |  <pre lang="java">for (int i = 0; i < list.size(); i++) {     System.out.println(list.get(i));  }</pre>  <br><br> <pre lang="java">for (int i : list) {    System.out.println(s);  }</pre>   | O(n) |
| **Get Last Element** | <pre lang="java">list.getLast();</pre> // returns the last element in this list. | O(1) |
| **Get First Element** | <pre lang="java">list.getFirst();</pre> // returns the first element in this list. | O(1) |



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
| `Arrays.fill(T[] arr, T val)`               | Assigns the specified value to each element of the specified array.                          | `int[] arr = new int[5];`<br>`Arrays.fill(arr, 7);`                        |
| `Arrays.asList(T... arr)`                   | Returns a fixed-size list backed by the specified array.                                      | `String[] arr = {"apple", "banana", "cherry"};`<br>`List<String> list = Arrays.asList(arr);` |
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








### Notes
* Add add StringBuilder and StringBuffer
* Add about Integer class
* How to insert at the start in the list
* How to insert at the start in the string builder
* Add TreeMap information
* Add Dequeue information
* Add pair class information and its corresponding import
* String class and compareTo method