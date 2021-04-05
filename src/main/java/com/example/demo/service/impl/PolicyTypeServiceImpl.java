package com.example.demo.service.impl;

import com.example.demo.model.PolicyType;
import com.example.demo.repository.PolicyTypeRepo;
import com.example.demo.service.PolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyTypeServiceImpl implements PolicyTypeService {

    private final PolicyTypeRepo repo;

    @Autowired
    public PolicyTypeServiceImpl(PolicyTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<PolicyType> getPolicyTypes(Long propertyId) {
        return repo.findAllByInsuredObjectId(propertyId);
    }
}
