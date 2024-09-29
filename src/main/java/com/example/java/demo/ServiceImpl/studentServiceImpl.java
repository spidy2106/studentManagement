package com.example.java.demo.ServiceImpl;

import com.example.java.demo.Entity.Student;
import com.example.java.demo.Repository.StudentRepository;
import com.example.java.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long studentId, Student studentDetails) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setStudentName(studentDetails.getStudentName());
        student.setStudentAge(studentDetails.getStudentAge());
        student.setStudentGender(studentDetails.getStudentGender());
        student.setStudentEmail(studentDetails.getStudentEmail());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }


}
