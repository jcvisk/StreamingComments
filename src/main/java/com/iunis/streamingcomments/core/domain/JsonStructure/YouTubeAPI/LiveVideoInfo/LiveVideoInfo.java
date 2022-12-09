package com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveVideoInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideoInfo implements Serializable {

    @JsonProperty("items")
    private List<LiveStreamingItems> items;
}
