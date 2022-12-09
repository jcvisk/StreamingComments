package com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveChatData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDetailsLiveChat {

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("profileImageUrl")
    private String profileImageUrl;
}
