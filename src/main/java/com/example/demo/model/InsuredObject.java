package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "insured_object")
public class InsuredObject {

    @Id
    Long id;

    private String objectName;

    @OneToMany(mappedBy = "insuredObject")
    private List<PolicyType> policyTypes;
}
