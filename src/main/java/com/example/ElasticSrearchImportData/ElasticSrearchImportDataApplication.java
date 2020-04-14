package com.example.ElasticSrearchImportData;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import sun.security.jca.GetInstance;

@SpringBootApplication
public class ElasticSrearchImportDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSrearchImportDataApplication.class, args);
	}


}
