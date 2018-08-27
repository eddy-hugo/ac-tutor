package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.dto.SubjectDTO;


@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<SubjectDTO, Long> {

}
