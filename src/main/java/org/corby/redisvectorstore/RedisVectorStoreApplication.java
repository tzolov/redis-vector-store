package org.corby.redisvectorstore;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.vectorstore.RedisVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisVectorStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisVectorStoreApplication.class, args);
    }

    @Bean
    public VectorStore redisVectorStore(EmbeddingClient embeddingClient) {
        RedisVectorStore.RedisVectorStoreConfig config = RedisVectorStore.RedisVectorStoreConfig.builder()
                .withURI("redis://localhost:6379")
                .build();

        return new RedisVectorStore(config, embeddingClient);
    }

}
