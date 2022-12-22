package com.umirrosi.springjsonapplication.entity;

import com.umirrosi.springjsonapplication.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_tab")
public class AddressEntity {
    @Id
    @TableGenerator(name = "address_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "address_id", initialValue = 0, allocationSize = 0)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id_generator")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "village", length = 50, nullable = false)
    private String village;

    @Column(name = "district", length = 50, nullable = false)
    private String district;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "province", length = 50, nullable = false)
    private String province;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customerAddress;

    public AddressEntity(AddressModel address)  {
        BeanUtils.copyProperties(address, this);
    }
}
