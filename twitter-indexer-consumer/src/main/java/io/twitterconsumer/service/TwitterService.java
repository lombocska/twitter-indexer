package io.twitterconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TwitterService {

    public static final String TWITTER_INDEX = "twitter";
    public static final String TWITTER_INDEX_TYPE = "tweets";

    private final RestHighLevelClient esClient;

    public void index(final String tweet) throws IOException {
        final IndexRequest source = new IndexRequest(TWITTER_INDEX, TWITTER_INDEX_TYPE).source(tweet, XContentType.JSON);
        final IndexResponse index = esClient.index(source, RequestOptions.DEFAULT);
        final String id = index.getId();
        log.debug("Indexed twitter tweet id: {}", id);
    }
}
