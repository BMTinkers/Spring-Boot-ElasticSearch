package com.example.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.ElasticResponseModel;
import com.example.springboot.repository.ElasticRepository;

@Service
public class ElasticService {
    private final ElasticRepository elasticRepository;

    @Autowired
    public ElasticService(ElasticRepository elasticRepository) {
        this.elasticRepository = elasticRepository;
    }

     public ElasticResponseModel save(ElasticResponseModel entity) {
        return elasticRepository.save(entity);
    }

    public ElasticResponseModel findById(UUID id) {
        return elasticRepository.findById(id.toString()).orElseThrow(() -> new NoSuchElementException("Document with id " + id + " not found."));
    }

    public List<ElasticResponseModel> findAll() {
        return (List<ElasticResponseModel>) elasticRepository.findAll();
    }

    public void delete(UUID id) {
        elasticRepository.deleteById(id.toString());
    }
}
