package com.demo.actutor.controller;

import java.util.List;
import java.util.Set;

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

import com.demo.actutor.dto.SessionDTO;
import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.repository.SessionRepository;

@RestController
@RequestMapping(path = "/session")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;
    
    // Get All sessions
    @GetMapping(path="/all")
    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll();
    }
    
    // Get a Single session
    @GetMapping(path="/{id}")
    public SessionDTO getSessionById(@PathVariable(value = "id") Long sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session", "id", sessionId));
    }
    // Create a new session
    @PostMapping(path="/add")
    public SessionDTO addSession(@Valid @RequestBody SessionDTO session) {
		return sessionRepository.save(session);
    }
    //Create a new Set of sessions
    @PostMapping(path="/adds")
    public void addSessions(@Valid @RequestBody Set<SessionDTO> sessions) {
    	sessions.stream().forEach(s -> addSession(s));
    }
    
    // Update a session
    @PutMapping(path="/update/{id}")
    public SessionDTO updateSession(@PathVariable(value = "id") Long sessionId, @Valid @RequestBody SessionDTO sessionDetails) {

    	SessionDTO session = sessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session", "id", sessionId));

    	session.setDatetime(sessionDetails.getDatetime());
    	session.setStudent(sessionDetails.getStudent());
    	session.setSubject(sessionDetails.getSubject());
    	session.setTutor(sessionDetails.getTutor());
    	session.setSessionDescription(sessionDetails.getSessionDescription());
    	
    	SessionDTO updatedSession =sessionRepository.save(session);
    	return updatedSession;
    
    }
    // Delete a session
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable(value = "id") Long sessionId) {
    	SessionDTO session = sessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session", "id", sessionId));

    	sessionRepository.delete(session);

        return ResponseEntity.ok().build();
    }
    
}
