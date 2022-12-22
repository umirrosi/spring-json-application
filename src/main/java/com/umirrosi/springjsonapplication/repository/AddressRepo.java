package com.umirrosi.springjsonapplication.repository;

import com.umirrosi.springjsonapplication.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
}
