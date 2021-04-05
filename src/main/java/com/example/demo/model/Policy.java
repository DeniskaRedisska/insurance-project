package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name must be not empty")
    @Size(max = 50,message = "Name is too long")
    private String ownerFullName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date must be not empty")
    @FutureOrPresent
    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate contractDate;

    @Min(value = 1,message = "Duration must be at least 1 year")
    @Max(value = 10,message = "Duration can not be longer than 10 years")
    private long contractDuration;

    @OneToOne
    @JoinColumn(name = "insured_obj_id")
    private InsuredObject insuredObject;

    @OneToOne
    @JoinColumn(name = "policy_type_id")
    private PolicyType policyType;


    @PrePersist
    public void init() {
        contractDate = LocalDate.now();
        endDate = startDate.plusYears(contractDuration);
    }
}
