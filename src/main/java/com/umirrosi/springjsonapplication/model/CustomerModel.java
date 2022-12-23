package com.umirrosi.springjsonapplication.model;

import com.umirrosi.springjsonapplication.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String fullName;
    private String gender;
    //private Long addressId;
    private List<AddressModel> address;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String placeOfBirth;

    private List<SchoolsModel> schools;
    //private Long schoolsId;
    public CustomerModel(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
