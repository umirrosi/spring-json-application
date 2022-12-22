package com.umirrosi.springjsonapplication.entity;

import com.umirrosi.springjsonapplication.model.AddressModel;
import com.umirrosi.springjsonapplication.model.CustomerModel;
import com.umirrosi.springjsonapplication.model.SchoolsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    public CustomerEntity(CustomerModel model) {
        this.fullName = model.getFullName();
        this.gender = model.getGender();
        this.dateOfBirth = model.getDateOfBirth();
        this.placeOfBirth = model.getPlaceOfBirth();
    }

    public void addAddress(AddressEntity address){
        this.addressEntities.add(address);
        address.setCustomerAddress(this);
    }

    public void addAddressList(List<AddressModel> addressModels){
        for(AddressModel item: addressModels){
            AddressEntity addressEntity = new AddressEntity(item);
            addAddress(addressEntity);
        }
    }

    public void addSchool(SchoolEntity school){
        this.schoolEntities.add(school);
        school.setCustomerSchool(this);
    }

    public void addSchoolList(List<SchoolsModel> schoolModels){
        for(SchoolsModel item: schoolModels){
            SchoolEntity schoolEntity = new SchoolEntity(item);
            addSchool(schoolEntity);
        }
    }
}
