package com.example.ElasticSrearchImportData;

import com.example.ElasticSrearchImportData.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.jsr.step.batchlet.BatchletAdapter;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableBatchProcessing
@EnableElasticsearchRepositories
public class BatchConfiguration {


    @Bean
    public Job importJob(JobBuilderFactory jobBuilderFactory,
                         Step importStep, Step renameAliasStep) {
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .start(importStep)
                .next(renameAliasStep)
                .build();
    }

    @Bean
    public Step importStep(StepBuilderFactory stepBuilderFactory,
                                   ItemReader ItemReader,
                                   ItemWriter ItemWriter) {
        return stepBuilderFactory.get("importStep")
                .chunk(20)
                .reader(ItemReader)
                .writer(ItemWriter)
                .build();
    }



}
