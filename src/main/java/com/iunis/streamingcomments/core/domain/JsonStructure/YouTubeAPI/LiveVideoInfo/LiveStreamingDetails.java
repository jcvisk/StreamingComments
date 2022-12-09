package com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveVideoInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveStreamingDetails {
    private String activeLiveChatId;
}
