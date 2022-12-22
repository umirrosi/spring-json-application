package com.umirrosi.springjsonapplication.service.Impl;

import com.umirrosi.springjsonapplication.model.CustomerModel;
import com.umirrosi.springjsonapplication.repository.CustomerRepo;
import com.umirrosi.springjsonapplication.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    public CustomerRepo repo;

    public CustomerServiceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<CustomerModel> getAll() {
        return null;
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {
        return Optional.empty();
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
