package com.example.demo.service;

import com.example.demo.model.InsuredObject;

import java.util.List;

public interface InsuredObjService {
    List<InsuredObject> getObjects();
    InsuredObject getObject(Long id);
}
