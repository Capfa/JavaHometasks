package ru.itmo.hw14;

import java.util.*;

public class Aplication {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(10);
        System.out.println(employees);

        //по имени
        Comparator<Employee> employeeComparator= new NameComparator();
        employees.sort(employeeComparator);
        System.out.println(employees);

       //по имени и зп
        Comparator<Employee> employeeSalaryNameComparator= new NameComparator().thenComparing(new SalaryComparator());;
        employees.sort(employeeSalaryNameComparator);
        System.out.println(employees);

        //по имени,зп и возрасту
        Comparator<Employee> employeeSalaryNameAgeComparator= new NameComparator().thenComparing(new SalaryComparator().thenComparing(new AgeComparator()));
        employees.sort(employeeSalaryNameAgeComparator);
        System.out.println(employees);



        List<Message> messageList=MessageGenerator.generate(10);
        System.out.println(messageList);
        MessageTask.countEachPriority(messageList);
        MessageTask.countEachCode(messageList);
        MessageTask.removeEach(messageList,MessagePriority.LOW);

    }
}
