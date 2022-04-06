package ru.itmo.hw14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Aplication {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(10);
        System.out.println(employees);


        Comparator<Employee> employeeComparator= new NameComparator();
        TreeSet<Employee> employeeTreeSet  = new TreeSet<>(employeeComparator);
        employeeTreeSet.add(employees.get(0));
        employeeTreeSet.add(employees.get(1));
        employeeTreeSet.add(employees.get(2));
        System.out.println(employeeTreeSet);

        Comparator<Employee> employeeSalaryNameComparator= new NameComparator().thenComparing(new SalaryComparator());;
        TreeSet<Employee> employeeTreeSetSalaryName  = new TreeSet<>(employeeSalaryNameComparator);
        employeeTreeSetSalaryName .add(employees.get(0));
        employeeTreeSetSalaryName .add(employees.get(1));
        employeeTreeSetSalaryName .add(employees.get(2));
        System.out.println(employeeTreeSetSalaryName );


    }
}
