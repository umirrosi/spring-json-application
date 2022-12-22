package com.umirrosi.springjsonapplication.service.Impl;

import com.umirrosi.springjsonapplication.entity.CustomerEntity;
import com.umirrosi.springjsonapplication.model.CustomerModel;
import com.umirrosi.springjsonapplication.repository.AddressRepo;
import com.umirrosi.springjsonapplication.repository.CustomerRepo;
import com.umirrosi.springjsonapplication.repository.SchoolRepo;
import com.umirrosi.springjsonapplication.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;
    private AddressRepo addressRepo;
    private SchoolRepo schoolRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, AddressRepo addressRepo, SchoolRepo schoolRepo) {
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
        this.schoolRepo = schoolRepo;
    }

    @Override
    public List<CustomerModel> getAll() {
        return this.customerRepo.findAll().stream().map(CustomerModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {
        if(model == null || model.getAddress().isEmpty() || model.getSchools().isEmpty()) {
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(model);
        entity.addAddressList(model.getAddress());
        entity.addSchoolList(model.getSchools());

        try{
            customerRepo.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerModel> update(Long id, CustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> delete(Long id) {
        return Optional.empty();
    }
}
