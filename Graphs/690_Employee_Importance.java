/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;

        HashMap<Integer, Employee> lookup = new HashMap<>();

        for (Employee emp : employees) {
            lookup.putIfAbsent(emp.id, emp);
        }

        return dfs(id, lookup);

    }

    int dfs(int id, HashMap<Integer, Employee> lookup) {
        Employee employee = lookup.get(id);
        if (employee == null)
            return 0;
        else if (employee.subordinates == null || employee.subordinates.size() == 0)
            return employee.importance;

        int importance = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            importance += dfs(subordinate, lookup);
        }

        return importance;

    }

}