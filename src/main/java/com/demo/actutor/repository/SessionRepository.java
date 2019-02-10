package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.model.Session;

@Repository("sessionRepository")
public interface SessionRepository extends JpaRepository<Session, Long> {

}
