package com.pharm.drug_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharm.drug_service.model.Drug;
import com.pharm.drug_service.repository.DrugRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/drugs")
@RequiredArgsConstructor
public class DrugController {

    private final DrugRepository drugRepository;

    @PostMapping
    public Drug create(@RequestBody Drug drug) {
        System.out.println("Creating drug: ");
        return drugRepository.save(drug);
    }
    

    @GetMapping
    public List<Drug> all(){
        return drugRepository.findAll();
    }

    @GetMapping("/{id}")
    public Drug get(@PathVariable Long id) {
         return drugRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Drug not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Drug update(@PathVariable Long id, @RequestBody Drug updated) {
            
        Drug existing = drugRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Drug not found with id: " + id));
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setPrice(updated.getPrice());
            return drugRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
          drugRepository.deleteById(id);
    }
}
