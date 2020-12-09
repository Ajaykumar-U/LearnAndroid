package com.example.learnandroid.recyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeList {
    public ArrayList<Employee> getData(){
        Employee e1 = new Employee(1, "Ajay", "Infrastructure Service");
        Employee e2 = new Employee(2, "Hemanth","AndroidDeveloper");
        Employee e3 = new Employee(4, "Arun","IT");
        Employee e4 = new Employee(3, "Chethan","Automation");
        Employee e5 = new Employee(5, "Amruth","Engineer");
        ArrayList<Employee> data = new ArrayList<>();
        data.add(e1);
        data.add(e2);
        data.add(e3);
        data.add(e4);
        data.add(e5);
        Collections.sort(data);
        return data;
    }
}

