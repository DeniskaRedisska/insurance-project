package com.example.demo.service;

import com.example.demo.model.PolicyType;

import java.util.List;

public interface PolicyTypeService {

    List<PolicyType> getPolicyTypes(Long propertyId);

}
