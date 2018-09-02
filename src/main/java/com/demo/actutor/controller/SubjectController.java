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

import com.demo.actutor.dto.SubjectDTO;
import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.repository.SubjectRepository;

@RestController
@RequestMapping(path = "/subject")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    @Autowired
    private SubjectRepository SubjectRepository;
    
    // Get all Subjects
    @GetMapping(path="/all")
    public List<SubjectDTO> getAllSubjects() {
        return SubjectRepository.findAll();
    }
    
    // Get a single Subject
    @GetMapping(path="/{id}")
    public SubjectDTO getSubjectById(@PathVariable(value = "id") Long subjectId) {
        return SubjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectId));
    }
    
    // Create a new Subject
    @PostMapping(path="/add")
    public SubjectDTO addSubject(@Valid @RequestBody SubjectDTO subject) {
		return SubjectRepository.save(subject);
    }
	
    // Update a Subject
    @PutMapping(path="/update/{id}")
    public SubjectDTO updateSubject(@PathVariable(value = "id") Long subjectId, @Valid @RequestBody SubjectDTO subjectDetails) {

    	SubjectDTO subject = SubjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectId));

    	subject.setSubjectName(subjectDetails.getSubjectName());
    	subject.setSubjectDescription(subjectDetails.getSubjectDescription());
    	
    	SubjectDTO updatedSubject =SubjectRepository.save(subject);
    	return updatedSubject;
    
    }
    // Delete a Subject
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") Long subjectId) {
    	SubjectDTO subject = SubjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectId));

    	SubjectRepository.delete(subject);

        return ResponseEntity.ok().build();
    }
    

}