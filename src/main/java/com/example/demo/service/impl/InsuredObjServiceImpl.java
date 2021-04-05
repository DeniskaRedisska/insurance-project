package com.example.demo.service.impl;

import com.example.demo.model.InsuredObject;
import com.example.demo.repository.InsuredObjRepo;
import com.example.demo.service.InsuredObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredObjServiceImpl implements InsuredObjService {

    private final InsuredObjRepo insuredObjRepo;

    @Autowired
    public InsuredObjServiceImpl(InsuredObjRepo insuredObjRepo) {
        this.insuredObjRepo = insuredObjRepo;
    }

    @Override
    public List<InsuredObject> getObjects() {
        return insuredObjRepo.findAll();
    }

    @Override
    public InsuredObject getObject(Long id) {
        return insuredObjRepo.getPropertyById(id).orElseThrow();
    }
}
