package com.example.config;

import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class StudentService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveStudent(Student s) {
        sessionFactory.getCurrentSession().save(s);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
    }

    @Transactional
    public void updateStudent(Student s) {
        sessionFactory.getCurrentSession().update(s);
    }

    @Transactional
    public void deleteStudent(int id) {
        Student s = sessionFactory.getCurrentSession().get(Student.class, id);
        if(s!=null) sessionFactory.getCurrentSession().delete(s);
    }
}
