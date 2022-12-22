package com.umirrosi.springjsonapplication.service.Impl;

import com.umirrosi.springjsonapplication.model.SchoolsModel;
import com.umirrosi.springjsonapplication.repository.SchoolRepo;
import com.umirrosi.springjsonapplication.service.SchoolService;

import java.util.List;
import java.util.Optional;

public class SchoolServiceImpl implements SchoolService {
    public SchoolRepo repo;

    public SchoolServiceImpl(SchoolRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<SchoolsModel> getAll() {
        return null;
    }

    @Override
    public Optional<SchoolsModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolsModel> save(SchoolsModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolsModel> update(Long id, SchoolsModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolsModel> delete(Long id) {
        return Optional.empty();
    }
}
