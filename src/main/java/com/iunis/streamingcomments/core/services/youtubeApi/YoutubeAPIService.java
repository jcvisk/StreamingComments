package com.iunis.streamingcomments.core.services.youtubeApi;

import com.iunis.streamingcomments.core.dto.ComentarioTO;

import java.util.List;

public interface YoutubeAPIService {
    public String getActiveLiveChatId(String videoId, String apiKey);
    public List<ComentarioTO> getCommentsLiveChatYoutube(String videoId, String apiKey);
}
