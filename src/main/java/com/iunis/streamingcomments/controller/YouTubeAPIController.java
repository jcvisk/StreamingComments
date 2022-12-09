package com.iunis.streamingcomments.controller;

import com.iunis.streamingcomments.core.services.youtubeApi.YoutubeAPIService;
import com.iunis.streamingcomments.core.dto.ComentarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/youtube/api")
public class YouTubeAPIController {

    @Autowired
    private YoutubeAPIService youtubeAPIService;

    @GetMapping("/getCommentsLiveChat/{videoId}/{apiKey}")
    public List<ComentarioTO> getCommentsLiveChat(@PathVariable String videoId, @PathVariable String apiKey) {
        return youtubeAPIService.getCommentsLiveChatYoutube(videoId, apiKey);
    }
}
