package com.example.elasticSearch.controller;

import com.example.elasticSearch.entity.Student;
import com.example.elasticSearch.repository.ElasticSearchQuery;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController

public class CustomerController {



    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @GetMapping("/findByFirstName")
    private SearchResponse findByName(@RequestBody String firstname) throws IOException {
        SearchResponse searchResponse = elasticSearchQuery.searchName(firstname);
        return searchResponse;
    }


    @PostMapping("/saveStudent")
    private String saveCustomer(@RequestBody Student student) throws IOException {
        elasticSearchQuery.saveCustomer(student);
        return "Studnet Saved Successfully";
    }

    @DeleteMapping("/deleteStudent/{id}")
    private String deleteCustomer(@PathVariable String id) throws IOException {
        elasticSearchQuery.deleteCustomer(id);
        return "deleted Successfully";
    }

    @PostMapping("/updateStudent")
    private String updateCustomer(@RequestBody Student student) throws IOException {
        elasticSearchQuery.updateCustomer(student);
        return "updated Successfully";
    }




}
