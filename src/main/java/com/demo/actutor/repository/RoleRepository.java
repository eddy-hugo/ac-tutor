package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.dto.RoleDTO;



@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleDTO, Long>{

	RoleDTO findByType(String type);


}
