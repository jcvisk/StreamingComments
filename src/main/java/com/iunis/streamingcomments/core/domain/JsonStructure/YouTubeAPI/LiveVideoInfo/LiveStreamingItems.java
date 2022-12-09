package com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveVideoInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveStreamingItems {

    @JsonProperty("liveStreamingDetails")
    private  LiveStreamingDetails liveStreamingDetails;
}
