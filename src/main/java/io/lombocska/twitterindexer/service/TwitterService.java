package io.lombocska.twitterindexer.service;


import io.lombocska.twitterindexer.client.TwitterClient;
import io.lombocska.twitterindexer.dispatcher.KafkaDispatcher;
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

    public TwitterService(final TwitterClient twitterClient, final KafkaDispatcher kafkaDispatcher) {
        this.twitterClient = twitterClient;
        this.kafkaDispatcher = kafkaDispatcher;

        twitterClient.connect();
    }

    public void index() {

        String msg = null;
        while (!twitterClient.isDone()) {
            try {
                msg = this.twitterClient.msgQueue.poll(5, TimeUnit.SECONDS);
                this.kafkaDispatcher.send(msg);
            } catch (InterruptedException e) {
                log.warn("Polling twitter API has stopped, because: {}", e.getMessage());
                this.twitterClient.close();
            }

            if (Strings.isNotBlank(msg)) {
                log.info(msg);
            }
        }
    }

}
