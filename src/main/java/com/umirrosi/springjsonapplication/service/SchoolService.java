package com.umirrosi.springjsonapplication.service;

import com.umirrosi.springjsonapplication.model.SchoolsModel;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    List<SchoolsModel> getAll();
    Optional<SchoolsModel> getById(Long id);
    Optional<SchoolsModel> save(SchoolsModel model);
    Optional<SchoolsModel> update(Long id, SchoolsModel model);
    Optional<SchoolsModel> delete(Long id);
}
