package com.example.springboot.repository;

import com.example.springboot.model.ElasticResponseModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<ElasticResponseModel, String> {
    List<ElasticResponseModel> findByExternalGuid(UUID externalGuid);
}
