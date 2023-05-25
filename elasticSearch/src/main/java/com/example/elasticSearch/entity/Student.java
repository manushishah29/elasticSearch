package com.example.elasticSearch.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@Document(indexName = "mkg")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
}
