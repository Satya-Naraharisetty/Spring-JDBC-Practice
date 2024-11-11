package com.sjdbc.sjdbc1.service;

import com.sjdbc.sjdbc1.repo.StudentRepo;
import com.sjdbc.sjdbc1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo Repo;

    public StudentRepo getStudentRepo() {
        return Repo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.Repo = studentRepo;
    }

    public void addStudent(Student s) {
//        System.out.println("Student added: ");
        Repo.save(s);
    }

    public List<Student> getStudents() {
        return Repo.findAll();
    }
}
