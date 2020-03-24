package io.lombocska.twitterindexer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tweet {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private Long id;
//    @JsonProperty("id_str")
//    private String idStr;
    @JsonProperty("text")
    private String text;
    @JsonProperty("source")
    private String source;
    @JsonProperty("truncated")
    private Boolean truncated;
//    @JsonProperty("in_reply_to_status_id")
//    private Object inReplyToStatusId;
//    @JsonProperty("in_reply_to_status_id_str")
//    private Object inReplyToStatusIdStr;
//    @JsonProperty("in_reply_to_user_id")
//    private Object inReplyToUserId;
//    @JsonProperty("in_reply_to_user_id_str")
//    private Object inReplyToUserIdStr;
//    @JsonProperty("in_reply_to_screen_name")
//    private Object inReplyToScreenName;
    @JsonProperty("user")
    private User user;
    @JsonProperty("geo")
    private Object geo;
    @JsonProperty("coordinates")
    private Object coordinates;
    @JsonProperty("place")
    private Object place;
    @JsonProperty("contributors")
    private Object contributors;
    @JsonProperty("is_quote_status")
    private Boolean isQuoteStatus;
//    @JsonProperty("extended_tweet")
//    private ExtendedTweet extendedTweet;
    @JsonProperty("quote_count")
    private Long quoteCount;
    @JsonProperty("reply_count")
    private Long replyCount;
    @JsonProperty("retweet_count")
    private Long retweetCount;
    @JsonProperty("favorite_count")
    private Long favoriteCount;
//    @JsonProperty("entities")
//    private Entities_ entities;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("retweeted")
    private Boolean retweeted;
    @JsonProperty("possibly_sensitive")
    private Boolean possiblySensitive;
    @JsonProperty("filter_level")
    private String filterLevel;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("timestamp_ms")
    private String timestampMs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


//    @JsonProperty("hashtags")
//    private List<Hashtag> hashtags = null;
//    @JsonProperty("urls")
//    private List<Url> urls = null;
//    @JsonProperty("user_mentions")
//    private List<UserMention> userMentions = null;
//    @JsonProperty("symbols")
//    private List<Object> symbols = null;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}


//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public class Url_ {
//
//        @JsonProperty("url")
//        private String url;
//        @JsonProperty("expanded_url")
//        private String expandedUrl;
//        @JsonProperty("display_url")
//        private String displayUrl;
//        @JsonProperty("indices")
//        private List<Long> indices = null;
//        @JsonIgnore
//        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

