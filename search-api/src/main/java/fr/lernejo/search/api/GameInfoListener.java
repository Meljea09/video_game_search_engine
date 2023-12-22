package fr.lernejo.search.api;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class GameInfoListener {

    private final RestHighLevelClient elasticsearchClient;

    @Autowired
    public GameInfoListener(RestHighLevelClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @RabbitListener(queues = AmqpConfiguration.GAME_INFO_QUEUE)
    public void onMessage(String message, @Header("game_id") String gameId) {
        // Indexation du document dans ElasticSearch (à implémenter)
    }
}
