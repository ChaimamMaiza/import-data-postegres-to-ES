package com.example.ElasticSrearchImportData;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ElasticsearchEmployeeRepository extends ElasticsearchCrudRepository<Employee, Integer> {
}
