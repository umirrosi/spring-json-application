package com.umirrosi.springjsonapplication.service.Impl;

import com.umirrosi.springjsonapplication.entity.AddressEntity;
import com.umirrosi.springjsonapplication.entity.CustomerEntity;
import com.umirrosi.springjsonapplication.entity.SchoolEntity;
import com.umirrosi.springjsonapplication.model.*;
import com.umirrosi.springjsonapplication.repository.AddressRepo;
import com.umirrosi.springjsonapplication.repository.CustomerRepo;
import com.umirrosi.springjsonapplication.repository.SchoolRepo;
import com.umirrosi.springjsonapplication.service.AddressService;
import com.umirrosi.springjsonapplication.service.CustomerService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if(model == null) {
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(model);
        //entity.addAddressList(model.getAddress());
        //entity.addSchoolList(model.getSchools());

        /*List<AddressModel> addressModels = new ArrayList<>();
        for (AddressModel address: model.getAddress()) {
            Optional<AddressModel> addressModel = this.saveAddress(address);
        }*/

        try{
            customerRepo.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SchoolsModel> saveSchool(SchoolsModel model) {
        if(model == null) {
            return Optional.empty();
        }
        SchoolEntity entity = new SchoolEntity(model);
        try {
            this.schoolRepo.save(entity);
            return Optional.of(new SchoolsModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<AddressModel> saveAddress(AddressModel model) {
        if(model == null) {
            return Optional.empty();
        }
        AddressEntity entity = new AddressEntity(model);
        try {
            this.addressRepo.save(entity);
            return Optional.of(new AddressModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public ResponseModel saveAll(CustomerRequest customerRequest) {
        //if(customerRequest.getCustomers().isEmpty()) {
        //    return new ResponseModel();
        //}

        ResponseModel responseModel = new ResponseModel();
        int countSuccess = 0;
        int countFailed = 0;


        List<CustomerModel> customerModels = new ArrayList<>();
        //List<SchoolsModel> schoolsModels = new ArrayList<>();

        for (CustomerModel model: customerRequest.getCustomers()) {
            // call method save
            Optional<CustomerModel> customerModel = this.save(model);
            // check datanya
            if(customerModel.isPresent()){
                customerModels.add(model);
                countSuccess++;
            }else {
                countFailed++;
            }
        }

       /* List<AddressModel> addressModels = new ArrayList<>();
        for (AddressModel address: customerRequest.getAddress()) {
            Optional<AddressModel> addressModel = this.saveAddress(address);
        }

        for (SchoolsModel schools: customerRequest.getSchools()) {
            Optional<SchoolsModel> schoolModel = this.saveSchool(schools);
        }*/


        // return  new CustomerResponse(customerModels, countSuccess, countFailed);
        responseModel.setDataCustomer(customerModels);
        responseModel.setSuccessSave(countSuccess);
        responseModel.setFailedSave(countFailed);
        return responseModel;
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
