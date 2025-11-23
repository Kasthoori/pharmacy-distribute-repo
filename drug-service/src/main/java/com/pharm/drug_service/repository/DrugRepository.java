package com.pharm.drug_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharm.drug_service.model.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    Optional<Drug> findByCode(String code);
    
}
