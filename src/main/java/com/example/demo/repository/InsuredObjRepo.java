package com.example.demo.repository;

import com.example.demo.model.InsuredObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuredObjRepo extends JpaRepository<InsuredObject,Long> {
    Optional<InsuredObject> getPropertyById(Long id);
}
