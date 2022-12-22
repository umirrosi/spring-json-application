package com.umirrosi.springjsonapplication.repository;

import com.umirrosi.springjsonapplication.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
