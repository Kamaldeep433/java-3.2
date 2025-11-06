package com.example;

import com.example.config.*;
import com.example.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student s1 = context.getBean(Student.class);
        System.out.println("Student: "+s1.getName()+" enrolled in "+s1.getCourse().getCourseName());

        StudentService studentService = context.getBean(StudentService.class);
        studentService.saveStudent(new Student("Bob", s1.getCourse()));

        List<Student> students = studentService.getAllStudents();
        for(Student s: students) {
            System.out.println("ID: "+s.getId()+" Name: "+s.getName());
        }

        AccountService accountService = context.getBean(AccountService.class);
        accountService.transfer(1,2,1000);

        context.close();
    }
}
