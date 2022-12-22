package com.umirrosi.springjsonapplication.service.Impl;

import com.umirrosi.springjsonapplication.model.AddressModel;
import com.umirrosi.springjsonapplication.repository.AddressRepo;
import com.umirrosi.springjsonapplication.repository.CustomerRepo;
import com.umirrosi.springjsonapplication.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    public AddressRepo repo;

    public AddressServiceImpl(AddressRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<AddressModel> getAll() {
        return null;
    }

    @Override
    public Optional<AddressModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> save(AddressModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> update(Long id, AddressModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> delete(Long id) {
        return Optional.empty();
    }
}
