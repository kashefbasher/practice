package com.stream;

import com.vo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JStream {

    Logger logger = Logger.getLogger(this.getClass().getName());
    List<Employee> employeeList = new ArrayList<>();

    public JStream() {
        employeeList.add(new Employee("bravo", 2));
        employeeList.add(new Employee("alpha", 3));
        employeeList.add(new Employee("charli", 2));
        employeeList.add(new Employee("doctor", 4));
    }

    private void sort() {
        System.out.println("sort()");
        List<Employee> map = employeeList.stream().sorted((e1,e2)->e1.compareTo(e2)).collect(Collectors.toCollection(ArrayList::new));
        map.forEach((e) -> System.out.println(e.getName()));
        System.out.println("------------------");
    }

    private void groupBy() {
        System.out.println("groupBy()");
        Map map = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        map.forEach((k,v) -> System.out.println(k+" = "+v));
        System.out.println("------------------");
    }

    private void partitioningBy() {
        System.out.println("partitioningBy()");
        Map map = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>2));
        map.forEach((k,v) -> System.out.println(k+" = "+ v));
        System.out.println("------------------");
    }

    private void maxBy() {
        System.out.println("maxBy()");
        Employee map = employeeList.stream().max(Comparator.comparing(Employee::getAge)).stream().findFirst().get();
        System.out.println(map.getName());
        System.out.println("------------------");
    }

    private void secondBiggest() {
        System.out.println("secondBiggest()");
        Integer age = employeeList.stream().map(e-> e.getAge()).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(age);
        System.out.println("------------------");
    }

    private void wordFrequency() {
        System.out.println("wordFrequency()");
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k,v)->System.out.println(k+" = "+ v));
        System.out.println("------------------");
    }

    private void charCount() {
        System.out.println("charCount()");
        String name = "kAshifbashir";
        ArrayList<Character> cList = name.chars().mapToObj(c-> (char)c).collect(Collectors.toCollection(ArrayList::new));
        Map map = cList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k,v)->System.out.println(k+" - "+v));
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        JStream stream = new JStream();
        stream.sort();
        stream.groupBy();
        stream.partitioningBy();
        stream.maxBy();
        stream.secondBiggest();
        stream.wordFrequency();
        stream.charCount();
    }
}