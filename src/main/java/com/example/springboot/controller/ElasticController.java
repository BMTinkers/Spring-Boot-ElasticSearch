package com.example.springboot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.model.ElasticResponseModel;
import com.example.springboot.service.ElasticService;

@RestController
@RequestMapping("/api/v1/responses")
public class ElasticController {
    @Autowired
    private ElasticService elasticService;

      @PostMapping
    public ElasticResponseModel create(@RequestBody ElasticResponseModel newEntity){
        return elasticService.save(newEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElasticResponseModel> getById(@PathVariable UUID id){
        try {
            ElasticResponseModel entity = elasticService.findById(id);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ElasticResponseModel> getAll(){
         return elasticService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ElasticResponseModel updatedEntity, @PathVariable UUID id) {
        try {
            elasticService.save(updatedEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        elasticService.delete(id);
    }
}
