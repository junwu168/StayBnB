package com.laioffer.staybooking.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {



    @Bean
    public RestHighLevelClient elasticsearchClient(
            @Value("${elasticsearch.address}")
            String elasticsearchAddress,
            @Value("${elasticsearch.username}")
            String elasticsearchUsername,
            @Value("${elasticsearch.password}")
            String elasticsearchPassword
    ) {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(elasticsearchAddress)
                .withBasicAuth(elasticsearchUsername, elasticsearchPassword)
                .build();


        return RestClients.create(clientConfiguration).rest();
    }
}

