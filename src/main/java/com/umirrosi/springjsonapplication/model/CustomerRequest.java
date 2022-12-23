package com.umirrosi.springjsonapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private List<CustomerModel> customers;
    //private List<AddressModel> address;
    //private List<SchoolsModel> schools;
}
