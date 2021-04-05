package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "policy_type")
public class PolicyType {

    @Id
    @NotNull(message = "You need to chose policy type")
    private Long id;

    private String typeName;

    @ManyToOne
    @JoinColumn(name = "insured_obj_id")
    private InsuredObject insuredObject;
}
