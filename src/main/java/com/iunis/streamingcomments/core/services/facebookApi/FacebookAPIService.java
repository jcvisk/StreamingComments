package com.iunis.streamingcomments.core.services.facebookApi;

import com.iunis.streamingcomments.core.dto.ComentarioTO;

import java.util.List;

public interface FacebookAPIService {
    public List<ComentarioTO> getCommentsLiveVideoFacebook(String liveVideoId, String accessToken);
}
