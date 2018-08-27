package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.dto.StudentDTO;


@Repository("studentRepository")
public interface StudentRepository  extends JpaRepository<StudentDTO, Long> {

}
