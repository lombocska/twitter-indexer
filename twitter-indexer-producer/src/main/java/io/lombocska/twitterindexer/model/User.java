package io.lombocska.twitterindexer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @JsonProperty("id")
    private Long id;
//    @JsonProperty("id_str")
//    private String idStr;
    @JsonProperty("name")
    private String name;
    @JsonProperty("screen_name")
    private String screenName;
    @JsonProperty("location")
    private Object location;
    @JsonProperty("url")
    private String url;
    @JsonProperty("description")
    private String description;
    @JsonProperty("translator_type")
    private String translatorType;
    @JsonProperty("protected")
    private Boolean _protected;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("followers_count")
    private Long followersCount;
    @JsonProperty("friends_count")
    private Long friendsCount;
    @JsonProperty("listed_count")
    private Long listedCount;
    @JsonProperty("favourites_count")
    private Long favouritesCount;
    @JsonProperty("statuses_count")
    private Long statusesCount;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("utc_offset")
    private Object utcOffset;
    @JsonProperty("time_zone")
    private Object timeZone;
    @JsonProperty("geo_enabled")
    private Boolean geoEnabled;
    @JsonProperty("lang")
    private Object lang;
    @JsonProperty("contributors_enabled")
    private Boolean contributorsEnabled;
    @JsonProperty("is_translator")
    private Boolean isTranslator;
//    @JsonProperty("profile_background_color")
//    private String profileBackgroundColor;
//    @JsonProperty("profile_background_image_url")
//    private String profileBackgroundImageUrl;
//    @JsonProperty("profile_background_image_url_https")
//    private String profileBackgroundImageUrlHttps;
//    @JsonProperty("profile_background_tile")
//    private Boolean profileBackgroundTile;
//    @JsonProperty("profile_link_color")
//    private String profileLinkColor;
//    @JsonProperty("profile_sidebar_border_color")
//    private String profileSidebarBorderColor;
//    @JsonProperty("profile_sidebar_fill_color")
//    private String profileSidebarFillColor;
//    @JsonProperty("profile_text_color")
//    private String profileTextColor;
//    @JsonProperty("profile_use_background_image")
//    private Boolean profileUseBackgroundImage;
//    @JsonProperty("profile_image_url")
//    private String profileImageUrl;
//    @JsonProperty("profile_image_url_https")
//    private String profileImageUrlHttps;
//    @JsonProperty("profile_banner_url")
//    private String profileBannerUrl;
//    @JsonProperty("default_profile")
//    private Boolean defaultProfile;
//    @JsonProperty("default_profile_image")
    private Boolean defaultProfileImage;
    @JsonProperty("following")
    private Object following;
//    @JsonProperty("follow_request_sent")
//    private Object followRequestSent;
//    @JsonProperty("notifications")
//    private Object notifications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
