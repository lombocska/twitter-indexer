package io.twitterconsumer.consumer;

import io.twitterconsumer.service.TwitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TwitterConsumer {

    @Value(value = "${twitter.consumer.kafka.topic}")
    private String twitterTopic;

    private final TwitterService twitterService;

    @KafkaListener(topics = "${twitter.consumer.kafka.topic}", clientIdPrefix = "${spring.kafka.consumer.client-id}-domain")
    public void process(final String payload) throws IOException {
        log.debug("Twitter tweet has consumed from topic: {} with payload: {}", twitterTopic, payload);

        twitterService.index(payload);
    }

}
