package com.example.springboot.model;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "response")
public class ElasticResponseModel {
    @Id
    private UUID guid; 
    private UUID externalGuid; 
    private UUID threadGuid;  
    private UUID entryGuid;  
    private UUID entryGuidParent;
    private String content;
    private ZonedDateTime created;
    private ZonedDateTime archived; 
    @Transient  
    private List<ElasticResponseModel> answers; 
    @Transient  
    private List<ElasticResponseModel> history;

  // getters and setters
}
