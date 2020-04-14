package com.example.ElasticSrearchImportData;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.AbstractElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchExceptionTranslator;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ElasticsearchRestTemplate extends AbstractElasticsearchTemplate {

    private RestHighLevelClient client;
    private ElasticsearchExceptionTranslator exceptionTranslator;


    public ElasticsearchRestTemplate(ElasticsearchConverter elasticsearchConverter ,RestHighLevelClient client ) {
        super(elasticsearchConverter);
        this.client = client;

    }

    @Bean
    public boolean indexExists() {
        GetIndexRequest request = new GetIndexRequest();
        request.indices("product");
        try {
            System.out.println("test indice "+client.indices().exists(request));
            return client.indices().exists(request);
        } catch (IOException e) {
            throw new ElasticsearchException("Error while for indexExists request: " + request.toString(), e);
        }
    }
}
