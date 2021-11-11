package com.example.classwork;

public class Student {
    int id;
    String name;
    String department;
    String course;

    public Student(){}

    public Student(String name, String department, String course){
        this.name = name;
        this.department = department;
        this.course = course;
    }

    public Student(int id, String name, String department, String course){
        this.id = id;
        this.name = name;
        this.department = department;
        this.course = course;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
