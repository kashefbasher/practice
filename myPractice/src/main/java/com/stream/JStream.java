package com.stream;

import com.vo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JStream {

    List<Employee> employeeList = new ArrayList<>();

    public JStream() {
        employeeList.add(new Employee("bravo", 2));
        employeeList.add(new Employee("alpha", 3));
        employeeList.add(new Employee("charli", 1));
        employeeList.add(new Employee("doctor", 4));
    }

    private void sort() {
        List<Employee> map = employeeList.stream().sorted((e1,e2)->e1.compareTo(e2)).collect(Collectors.toCollection(ArrayList::new));
        map.forEach((e) -> System.out.println(e.getName()));
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

    private void secondBiggest() {
        Integer age = employeeList.stream().map(e-> e.getAge()).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(age);
    }

    private void wordFrequency() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k,v)->System.out.println(k+" = "+ v));
    }

    private void charCount() {
        String name = "kAshifbashir";
        ArrayList<Character> cList = name.chars().mapToObj(c-> (char)c).collect(Collectors.toCollection(ArrayList::new));
        Map map = cList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k,v)->System.out.println(k+" - "+v));
    }

    public static void main(String[] args) {
        JStream stream = new JStream();
        stream.sort();
        stream.groupBy();
        stream.partisionBy();
        stream.maxBy();
        stream.secondBiggest();
        stream.wordFrequency();
        stream.charCount();
    }
}