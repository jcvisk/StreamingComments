package com.iunis.streamingcomments.controller;

import com.iunis.streamingcomments.core.dto.ComentarioTO;
import com.iunis.streamingcomments.core.services.facebookApi.FacebookAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facebook/api")
public class FacebookAPIController {

    @Autowired
    private FacebookAPIService facebookAPIService;

    @GetMapping("/getComments/{liveVideoId}/{accessToken}")
    public List<ComentarioTO> getCommentsLiveVideo(@PathVariable String liveVideoId, @PathVariable String accessToken){
        return facebookAPIService.getCommentsLiveVideoFacebook(liveVideoId, accessToken);
    }
}
