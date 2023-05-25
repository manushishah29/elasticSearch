package com.example.elasticSearch.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int age;
}
