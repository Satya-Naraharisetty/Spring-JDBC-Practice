package com.sjdbc.sjdbc1;
import com.sjdbc.sjdbc1.model.Student;

import com.sjdbc.sjdbc1.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class Sjdbc1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Sjdbc1Application.class, args);

        Student s = context.getBean(Student.class);
        s.setRollNo(3);
        s.setName("Sri");
        s.setMarks(100);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println(students);
    }

}
