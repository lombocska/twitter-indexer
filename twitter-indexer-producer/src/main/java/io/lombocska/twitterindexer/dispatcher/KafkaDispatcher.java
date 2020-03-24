package io.lombocska.twitterindexer.dispatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lombocska.twitterindexer.metrics.MetricService;
import io.lombocska.twitterindexer.metrics.aop.LogExceptionMetric;
import io.lombocska.twitterindexer.model.Tweet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaDispatcher {

    @Value("${twitter.indexer.kafka.topic}")
    private String twitterTopic;

    @Value("${spring.application.name}")
    private String appName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MetricService metricService;
    private final ObjectMapper objectMapper;

    @LogExceptionMetric
    public void send(final Tweet tweet) {
        final String serializedTweet = serialize(tweet);
        this.kafkaTemplate.send(twitterTopic, serializedTweet);
        log.debug("Tweet has sent: {} to the topic: {}", serializedTweet, twitterTopic);
        metricService.countSentTwitterMessage();
    }

    private String serialize(final Tweet tweet) {
        try {
            return objectMapper.writeValueAsString(tweet);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error has occurred while serializing message.");
        }
    }

}
