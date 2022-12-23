package com.umirrosi.springjsonapplication.model;

import com.umirrosi.springjsonapplication.entity.SchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolsModel {
    private Long id;
    private String title;
    private String name;
    private String level;

    public SchoolsModel (SchoolEntity schoolEntity) {
        BeanUtils.copyProperties(schoolEntity, this);
    }

}
