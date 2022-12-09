package com.iunis.streamingcomments.core.domain.JsonStructure.FacebookAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIGraphLiveVideo {

    @JsonProperty("data")
    private List<LiveVideosData> data;
}