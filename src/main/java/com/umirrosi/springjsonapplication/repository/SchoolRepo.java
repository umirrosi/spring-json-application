package com.umirrosi.springjsonapplication.repository;

import com.umirrosi.springjsonapplication.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends JpaRepository<SchoolEntity, Long> {
}
