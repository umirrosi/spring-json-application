package com.umirrosi.springjsonapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolsModel {
    private Long id;
    private String title;
    private String name;
    private String level;

}
