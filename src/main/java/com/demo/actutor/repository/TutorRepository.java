package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demo.actutor.model.Tutor;


@Repository("tutorRepository")
@CrossOrigin(origins = "http://localhost:4200")
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}