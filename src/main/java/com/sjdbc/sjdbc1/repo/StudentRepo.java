package com.sjdbc.sjdbc1.repo;

import com.sjdbc.sjdbc1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        int rowsAffected = jdbc.update("insert into student(SRollNo, SName, SMarks) values(?,?,?)", s.getRollNo(), s.getName(), s.getMarks());
        if (rowsAffected == 1) {
            System.out.println("Student saved");
        } else {
            System.out.println("Student not saved");
        }
    }

    public List<Student> findAll() {

        String sql = "select * from student";

        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("SRollNo"));
            s.setName(rs.getString("SName"));
            s.setMarks(rs.getInt("SMarks"));
            return s;
        });
    }
}
