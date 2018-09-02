package com.demo.actutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.actutor.dto.DatetimeDTO;


@Repository("datetimeRepository")
public interface DatetimeRepository extends JpaRepository<DatetimeDTO, Long>{

}
