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

import com.demo.actutor.dto.TutorDTO;
import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.repository.TutorRepository;



@RestController
@RequestMapping(path="/tutor")
@CrossOrigin(origins = "http://localhost:4200")
public class TutorController {


	@Autowired
    private TutorRepository tutorRepository;

    // Get All Tutors
    @GetMapping(path="/all")
    public List<TutorDTO> getAllTutors() {
        return tutorRepository.findAll();
    }
    
 // Create a new Tutor
    @PostMapping(path="/add")
    public TutorDTO addTutor(@Valid @RequestBody TutorDTO tutor) {
		return tutorRepository.save(tutor);
    }
    // Get a Single Tutor
    @GetMapping(path="/{id}")
    public TutorDTO getTutorById(@PathVariable(value = "id") Long tutorId) {
        return tutorRepository.findById(tutorId).orElseThrow(() -> new ResourceNotFoundException("Tutor", "id", tutorId));
    }
    // Update a Tutor
    @PutMapping(path="/update/{id}")
    public TutorDTO updateTutor(@PathVariable(value = "id") Long tutorId, @Valid @RequestBody TutorDTO tutorDetails) {

        TutorDTO tutor = tutorRepository.findById(tutorId).orElseThrow(() -> new ResourceNotFoundException("Tutor", "id", tutorId));

        tutor.setUsername(tutorDetails.getUsername());
        tutor.setFirstName(tutorDetails.getFirstName());
        tutor.setLastName(tutorDetails.getLastName());
        tutor.setEmail(tutorDetails.getEmail());
        tutor.setPhone(tutorDetails.getPhone());
        tutor.setSubjects(tutorDetails.getSubjects());
        tutor.setAvailableTime(tutorDetails.getAvailableTime());
        
        return  tutorRepository.save(tutor);
    }
    // Delete a Tutor
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteTutor(@PathVariable(value = "id") Long tutorId) {
        TutorDTO tutor = tutorRepository.findById(tutorId).orElseThrow(() -> new ResourceNotFoundException("User", "id", tutorId));

        tutorRepository.delete(tutor);

        return ResponseEntity.ok().build();
    }
}
	
