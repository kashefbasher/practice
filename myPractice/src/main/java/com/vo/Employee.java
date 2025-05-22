package com.vo;

import java.util.List;

public class Employee implements Comparable {

    private String name;
    private Integer age;

    private List<String> list;

    public Employee(String name, Integer age, List<String> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Employee)o).getName());
    }
}
