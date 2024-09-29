package com.example.java.demo.Controller;

import com.example.java.demo.Entity.Student;
import com.example.java.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test successful!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    @PostMapping("/saveStudent")
    public Student addStudent(@RequestBody Student student) {
        System.out.println("clicked here");
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(id, studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
