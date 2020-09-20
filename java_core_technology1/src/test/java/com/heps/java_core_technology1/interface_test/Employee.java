package com.heps.java_core_technology1.interface_test;

public class Employee implements Comparable<Employee>{


    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary= salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.salary,salary);
    }
}
