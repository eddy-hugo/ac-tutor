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

import com.demo.actutor.dto.DatetimeDTO;
import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.repository.DatetimeRepository;

@RestController
@RequestMapping(path = "/datetime")
@CrossOrigin(origins = "http://localhost:4200")
public class DatetimeController {

	@Autowired
    private DatetimeRepository DatetimeRepository;
    
    // Get all Datetimes
    @GetMapping(path="/all")
    public List<DatetimeDTO> getAllDatetimes() {
        return DatetimeRepository.findAll();
    }
    
    // Get a single Datetime
    @GetMapping(path="/{id}")
    public DatetimeDTO getDatetimeById(@PathVariable(value = "id") Long datetimeId) {
        return DatetimeRepository.findById(datetimeId).orElseThrow(() -> new ResourceNotFoundException("Datetime", "id", datetimeId));
    }
    
    // Create a new Datetime
    @PostMapping(path="/add")
    public DatetimeDTO addDatetime(@Valid @RequestBody DatetimeDTO Datetime) {
		return DatetimeRepository.save(Datetime);
    }
	
    // Update a Datetime
    @PutMapping(path="/update/{id}")
    public DatetimeDTO updateDatetime(@PathVariable(value = "id") Long datetimeId, @Valid @RequestBody DatetimeDTO datetimeDetails) {

    	DatetimeDTO datetime = DatetimeRepository.findById(datetimeId).orElseThrow(() -> new ResourceNotFoundException("Datetime", "id", datetimeId));

    	datetime.setStartDateTime(datetimeDetails.getStartDateTime());
    	datetime.setEndDateTime(datetimeDetails.getEndDateTime());
    	
    	DatetimeDTO updatedDatetime =DatetimeRepository.save(datetime);
    	return updatedDatetime;
    
    }
    // Delete a Datetime
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteDatetime(@PathVariable(value = "id") Long datetimeId) {
    	DatetimeDTO Datetime = DatetimeRepository.findById(datetimeId).orElseThrow(() -> new ResourceNotFoundException("Datetime", "id", datetimeId));

    	DatetimeRepository.delete(Datetime);

        return ResponseEntity.ok().build();
    }
    

}