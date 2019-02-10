package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.model.Subject;


@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
