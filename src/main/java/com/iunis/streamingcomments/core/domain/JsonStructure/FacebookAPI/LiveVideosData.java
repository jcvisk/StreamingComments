package com.iunis.streamingcomments.core.domain.JsonStructure.FacebookAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveVideosData {
    /*Id del comentario*/
    private String id;
    /*Mensaje del comentario*/
    private String message;
    /*Hora y fecha del comentario*/
    private String created_time;
    /*Datos de quien hizo el comentario*/
    @JsonProperty("from")
    private LiveVideosDataFrom from;
}
