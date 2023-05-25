package com.example.elasticSearch.repository;

import com.example.elasticSearch.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,String> {
}
