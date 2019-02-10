package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.model.Role;



@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByType(String type);


}
