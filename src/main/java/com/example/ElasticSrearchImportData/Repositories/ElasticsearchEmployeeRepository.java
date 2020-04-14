package com.example.ElasticSrearchImportData.Repositories;

import com.example.ElasticSrearchImportData.models.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ElasticsearchEmployeeRepository extends ElasticsearchCrudRepository<Employee, Integer> {
}
