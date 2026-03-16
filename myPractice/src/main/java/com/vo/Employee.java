package com.vo;

import java.util.List;

public class Employee implements Comparable<Employee> {
    private  String name;
    private  String email;
    private  Integer age;
    private  String address;
    private  String designation;
    private  List<String> qualifications;
    private List<String> list;

    public Employee(Integer age) {
        this.age = age;
    }
    public Employee(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Employee(String name, Integer age, List<String> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public Employee(Employee.EmployeeBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.address = builder.address;
        this.designation = builder.designation;
        this.qualifications = builder.qualifications;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDesignation() {
        return designation;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    @Override
    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                ", designation='" + designation + '\'' +
//                ", qualifications=" + qualifications +
//                '}';
        return age+"";
    }

    public static class EmployeeBuilder {
        private final String name;
        private final String email;
        private Integer age;
        private String address;
        private String designation;
        private List<String> qualifications;

        public EmployeeBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public EmployeeBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder designation(String designation) {
            this.designation = designation;
            return this;
        }

        public EmployeeBuilder qualifications(List<String> qualifications) {
            this.qualifications = qualifications;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public int compareTo(Employee o) {

        return 0;
    }
}