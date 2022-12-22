package com.umirrosi.springjsonapplication.entity;

import com.umirrosi.springjsonapplication.model.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_req_tab")
public class CustomerEntity {
    @Id
    @TableGenerator (name = "customer_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_id_generator")
    private Long id;

    @Column(name = "fullName", length = 100, nullable = false)
    private String fullName;

    @Column(name = "gender", length = 15, nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @OneToMany(mappedBy = "customerAddress", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddressEntity> addressEntities = new HashSet<>();

    @OneToMany(mappedBy = "customerSchool", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SchoolEntity> schoolEntities = new HashSet<>();

    public CustomerEntity(CustomerModel customerRequest) {
        BeanUtils.copyProperties(customerRequest, this);
    }


}
