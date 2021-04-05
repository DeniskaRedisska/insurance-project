package com.example.demo.service.impl;

import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepo;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepo policyRepo;

    @Autowired
    public PolicyServiceImpl(PolicyRepo policyRepo) {
        this.policyRepo = policyRepo;
    }

    @Override
    public void create(Policy policy) {
        policyRepo.save(policy);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }
}
