package com.demo.actutor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.model.Student;
import com.demo.actutor.repository.StudentRepository;

@RestController
@RequestMapping(path = "/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
    @Autowired
    private StudentRepository studentRepository;
    
    // Get all students
    @GetMapping(path="/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Get a single student
    @GetMapping(path="/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));
    }
    
    // Create a new student
    @PostMapping(path="/add")
    public Student addStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
    }
	
    // Update a Student
    @PutMapping(path="/update/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long studentId, @Valid @RequestBody Student studentDetails) {

    	Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

    	student.setUsername(studentDetails.getUsername());
    	student.setFirstName(studentDetails.getFirstName());
    	student.setLastName(studentDetails.getLastName());
    	student.setEmail(studentDetails.getEmail());
    	student.setPhone(studentDetails.getPhone());
    	
    	Student updatedStudent =studentRepository.save(student);
    	return updatedStudent;
    
    }
    // Delete a Student
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
    	Student Student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

    	studentRepository.delete(Student);

        return ResponseEntity.ok().build();
    }
    

}
