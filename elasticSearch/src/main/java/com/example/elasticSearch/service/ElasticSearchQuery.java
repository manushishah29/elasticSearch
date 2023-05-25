package com.example.elasticSearch.service;

import com.example.elasticSearch.entity.Student;
import com.google.gson.Gson;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class ElasticSearchQuery {

    private final String indexName = "mkg";

    private final RestHighLevelClient restHighLevelClient;

    public ElasticSearchQuery(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;

    }

    public SearchResponse searchName(String query) throws IOException {
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", query));
        System.out.println("searchSourceBuilder.query().queryName() = " + searchSourceBuilder.query().queryName());
        searchRequest.source(searchSourceBuilder);

        return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }

    public String saveCustomer(Student student) throws IOException {

        IndexRequest indexRequest = new IndexRequest(indexName).id(student.getId())
                .source(new Gson().toJson(student), XContentType.JSON);

        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return "Added Successfully";
    }

    public String deleteCustomer(String id) throws IOException {


        DeleteRequest request = new DeleteRequest(indexName).id(id);
        DeleteResponse hh= restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        return "Deleted Successfully";
    }

    public void updateCustomer(Student student) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName)
                .source(new Gson().toJson(student), XContentType.JSON);
        restHighLevelClient.update(new UpdateRequest(indexName, student.getId())
                .doc(indexRequest)
                .docAsUpsert(true), RequestOptions.DEFAULT);


    }
}





