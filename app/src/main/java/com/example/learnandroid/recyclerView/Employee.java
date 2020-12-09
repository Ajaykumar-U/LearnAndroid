package com.example.learnandroid.recyclerView;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name, job;
    public Employee(int id, String name, String job){
        this.id=id;
        this.name=name;
        this.job=job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
