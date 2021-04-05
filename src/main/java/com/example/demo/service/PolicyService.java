package com.example.demo.service;

import com.example.demo.model.Policy;

import java.util.List;

public interface PolicyService {
    void create(Policy policy);

    List<Policy> getAllPolicies();

}
