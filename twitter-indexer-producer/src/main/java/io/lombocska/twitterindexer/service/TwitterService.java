package io.lombocska.twitterindexer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lombocska.twitterindexer.client.TwitterClient;
import io.lombocska.twitterindexer.dispatcher.KafkaDispatcher;
import io.lombocska.twitterindexer.model.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional(value = "kafkaTransactionManager")
public class TwitterService {

    private TwitterClient twitterClient;
    private KafkaDispatcher kafkaDispatcher;
    private ObjectMapper objectMapper;

    public TwitterService(final TwitterClient twitterClient,
                          final KafkaDispatcher kafkaDispatcher,
                          final ObjectMapper objectMapper) {
        this.twitterClient = twitterClient;
        this.kafkaDispatcher = kafkaDispatcher;
        this.objectMapper = objectMapper;

        twitterClient.connect();
    }

    public void index() {

        String msg = null;
        while (!twitterClient.isDone()) {
            try {
                msg = this.twitterClient.msgQueue.poll(5, TimeUnit.SECONDS);
                final Tweet tweet = objectMapper.readValue(msg, Tweet.class);
                this.kafkaDispatcher.send(tweet);
            } catch (InterruptedException e) {
                log.warn("Polling twitter API has stopped, because: {}", e.getMessage());
                this.twitterClient.close();
            } catch (JsonMappingException e) {
                log.warn("Message could not have deseralized: {}", msg);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            if (Strings.isNotBlank(msg)) {
                log.info(msg);
            }
        }
    }

}
