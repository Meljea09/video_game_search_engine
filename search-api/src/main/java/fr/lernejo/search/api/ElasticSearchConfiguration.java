package fr.lernejo.search.api;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticSearchConfiguration {

    @Bean
    public RestHighLevelClient elasticsearchClient(
            @Value("${elasticsearch.host:localhost}") String host,
            @Value("${elasticsearch.port:9200}") int port,
            @Value("${elasticsearch.username:elastic}") String username,
            @Value("${elasticsearch.password:admin}") String password) {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .withBasicAuth(username, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
