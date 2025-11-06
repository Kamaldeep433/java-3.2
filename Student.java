package com.example.model;

import com.example.config.Course;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Transient
    private Course course;
    private int marks;

    public Student() {}
    public Student(String name, Course course) { this.name=name; this.course=course; }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public Course getCourse() { return course; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks=marks; }
}
