### **1. Data Structures**

- **Arrays**:
  ```typescript
  const arr: number[] = [1, 2, 3];
  arr.push(4);   // Adds 4 at the end
  arr.pop();     // Removes last element
  ```

- **Objects**:
  ```typescript
  const obj = { name: 'Alice', age: 25 };
  console.log(obj.name); // 'Alice'
  ```

- **Maps**:
  ```typescript
  const map = new Map();
  map.set('key', 'value');
  console.log(map.get('key')); // 'value'
  ```

- **Sets**:
  ```typescript
  const set = new Set([1, 2, 3]);
  set.add(4); // {1, 2, 3, 4}
  ```

### **2. String Methods**

- **Length**: `str.length`
- **Slice**: `str.slice(0, 5)`
- **Substring**: `str.substring(1, 3)`
- **Split**: `str.split(' ')`
- **Includes**: `str.includes('word')`
- **Replace**: `str.replace('old', 'new')`
  
### **3. Array Methods**

- **map()**: Transform each item.
  ```javascript
  const result = arr.map(x => x * 2);
  ```
- **filter()**: Filter elements.
  ```javascript
  const even = arr.filter(x => x % 2 === 0);
  ```
- **reduce()**: Aggregate data.
  ```javascript
  const sum = arr.reduce((acc, val) => acc + val, 0);
  ```
- **find()**: Find an element.
  ```javascript
  const item = arr.find(x => x > 2);
  ```

### **4. Loops**

- **For Loop**:
  ```typescript
  for (let i = 0; i < 5; i++) {
    console.log(i);
  }
  ```

- **ForEach** (Arrays):
  ```typescript
  arr.forEach(x => console.log(x));
  ```

- **For...of**:
  ```typescript
  for (const val of arr) {
    console.log(val);
  }
  ```

### **5. TypeScript Types**

- **Union Types**:
  ```typescript
  let value: string | number;
  value = 'Hello'; // valid
  value = 10;      // valid
  ```

- **Tuple**:
  ```typescript
  let tuple: [string, number] = ['Alice', 25];
  ```

- **Enum**:
  ```typescript
  enum Direction { Up, Down, Left, Right }
  ```

### **6. Asynchronous Programming**

- **Promises**:
  ```typescript
  const fetchData = new Promise((resolve, reject) => {
    // Some async task
    resolve('Data');
  });
  fetchData.then(data => console.log(data));
  ```

- **Async/Await**:
  ```typescript
  async function getData() {
    const result = await fetchData();
    console.log(result);
  }
  ```

### **7. Error Handling**

- **Try/Catch**:
  ```typescript
  try {
    throw new Error('Something went wrong!');
  } catch (error) {
    console.error(error.message);
  }
  ```

### **8. Object/Array Destructuring**

- **Object**:
  ```typescript
  const person = { name: 'John', age: 30 };
  const { name, age } = person;
  ```
  
- **Array**:
  ```typescript
  const [first, second] = [10, 20];
  ```

### **9. Spread and Rest Operators**

- **Spread** (copy or expand):
  ```typescript
  const arr1 = [1, 2, 3];
  const arr2 = [...arr1, 4, 5]; // [1, 2, 3, 4, 5]
  ```

- **Rest** (group arguments):
  ```typescript
  function sum(...numbers: number[]) {
    return numbers.reduce((acc, num) => acc + num);
  }
  ```

### **10. Classes and Inheritance**

- **Class**:
  ```typescript
  class Animal {
    name: string;
    constructor(name: string) {
      this.name = name;
    }
    makeSound() {
      console.log('Sound');
    }
  }
  ```

- **Inheritance**:
  ```typescript
  class Dog extends Animal {
    bark() {
      console.log('Woof!');
    }
  }
  ```

### **11. TypeScript Generics**

- **Generic Function**:
  ```typescript
  function identity<T>(arg: T): T {
    return arg;
  }
  const output = identity<number>(10); // 10
  ```

### **12. Modules and Imports/Exports**

- **Named Export**:
  ```typescript
  export const myVar = 10;
  ```

- **Default Export**:
  ```typescript
  export default class MyClass { /* ... */ }
  ```

- **Importing**:
  ```typescript
  import MyClass, { myVar } from './myModule';
  ```

### **13. Type Guards**
  
- **Type Guards**:
  ```typescript
  function isString(value: unknown): value is string {
    return typeof value === 'string';
  }
  
  const input: unknown = 'Hello';
  if (isString(input)) {
    console.log(input.toUpperCase()); // Safe to use string methods
  }
  ```

### **14. Interfaces**

- **Interface**:
  ```typescript
  interface User {
    name: string;
    age: number;
  }

  const user: User = { name: 'Alice', age: 25 };