package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) throws Exception {

        flatMap();
    }



    public static void flatMapNested() {

        List<Employee> hrEmployees = Arrays.asList(new Employee("Alice"), new Employee("Bob"));
        List<Employee> engineeringEmployees = Arrays.asList(new Employee("Charlie"), new Employee("David"));
        List<Department> departments = Arrays.asList(new Department("HR", hrEmployees), new Department("Engineering", engineeringEmployees));

        // Using flatMap to get a flattened list of all employee names
        List<String> allEmployeeNames = departments.stream().flatMap(department -> department.getEmployees().stream())
                // 1. Transform each department into a stream of employees
                .map(Employee::getName)         // 2. Map each employee object to their name (String)
                .collect(Collectors.toList());  // 3. Collect into a final list

        System.out.println(allEmployeeNames);
    }

    public static void flatMap() {

        List<List<String>> teams = Arrays.asList(Arrays.asList("Alice", "Bob"), Arrays.asList("Charlie", "David", "Eve"), Arrays.asList("Frank"));

        // Using flatMap to get a single list of all players
        List<String> allPlayers = teams.stream().flatMap(l -> l.stream())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(allPlayers);
        // Output: [Alice, Bob, Charlie, David, Eve, Frank]
    }

}

class Employee {
    String name;
    // Constructor, getters, setters
    public Employee(String name) { this.name = name; }
    public String getName() { return name; }
}

class Department {
    String deptName;
    List<Employee> employees;
    // Constructor, getters, setters
    public Department(String deptName, List<Employee> employees) {
        this.deptName = deptName;
        this.employees = employees;
    }
    public List<Employee> getEmployees() { return employees; }
}