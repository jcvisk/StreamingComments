package com.iunis.streamingcomments.core.domain.JsonStructure.FacebookAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideosDataFrom {
    /*Id de la cuenta que hizo el comentario*/
    private String id;
    /*nombre del la cuenta que hizo el comentario*/
    private String name;
}
