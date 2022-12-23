package com.umirrosi.springjsonapplication.model;

import com.umirrosi.springjsonapplication.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
    private Long id;
    private String name;
    private String address;
    private String village;
    private String district;
    private String city;
    private String province;

    public AddressModel(AddressEntity addressEntity){
        BeanUtils.copyProperties(addressEntity, this);
    }
}
