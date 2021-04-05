package com.example.demo.repository;

import com.example.demo.model.PolicyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyTypeRepo extends JpaRepository<PolicyType,Long> {
    List<PolicyType> findAllByInsuredObjectId(Long id);
}
