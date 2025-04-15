package com.stream;

import com.vo.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JStream {

    List<Employee> employeeList = new ArrayList<>();

    public JStream() {
        employeeList.add(new Employee("bravo", 2));
        employeeList.add(new Employee("alpha", 3));
        employeeList.add(new Employee("charli", 1));
        employeeList.add(new Employee("doctor", 4));
    }

    private void groupBy() {
        Map map = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        map.forEach((k,v) -> System.out.println(k+" = "+v));
    }

    private void partisionBy() {
        Map map = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>2));
        map.forEach((k,v) -> System.out.println(k+" = "+ v));
    }

    private void maxBy() {
        Employee map = employeeList.stream().max(Comparator.comparing(Employee::getAge)).stream().findFirst().get();
        System.out.println(map.getName());
    }


    public static void main(String[] args) {
        JStream stream = new JStream();
        stream.groupBy();
        stream.partisionBy();
        stream.maxBy();
    }
}