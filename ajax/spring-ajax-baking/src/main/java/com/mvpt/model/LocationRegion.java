package com.mvpt.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location_region")
public class LocationRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "province_id")
    private long provinceId;

    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "district_idd")
    private long districtId;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "ward_id")
    private long wardId;

    @Column(name = "ward_name")
    private String wardName;

    private String address;

    @OneToOne (mappedBy = "locationRegion")
    private Customer customer;



}
