package com.umirrosi.springjsonapplication.service;

import com.umirrosi.springjsonapplication.model.*;
import org.apache.coyote.Response;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    Optional<CustomerModel> save(CustomerModel model);
    Optional<SchoolsModel> saveSchool(SchoolsModel model);
    Optional<AddressModel> saveAddress(AddressModel model);
    ResponseModel saveAll(CustomerRequest request);
    Optional<CustomerModel> update(Long id, CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}
