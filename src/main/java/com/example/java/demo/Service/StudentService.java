package com.example.java.demo.Service;

import com.example.java.demo.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long studentId);
    Student addStudent(Student student);
    Student updateStudent(Long studentId, Student studentDetails);
    void deleteStudent(Long studentId);

}
