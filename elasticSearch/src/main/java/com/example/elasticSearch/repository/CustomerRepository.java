package com.example.elasticSearch.repository;

import com.example.elasticSearch.entity.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {
    List<Customer> findByFirstname(String lastname);
}
