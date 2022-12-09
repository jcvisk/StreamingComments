package com.iunis.streamingcomments.core.services.facebookApi;

import com.iunis.streamingcomments.core.domain.JsonStructure.FacebookAPI.APIGraphLiveVideo;
import com.iunis.streamingcomments.core.domain.JsonStructure.FacebookAPI.LiveVideosData;
import com.iunis.streamingcomments.core.dto.ComentarioTO;
import com.iunis.streamingcomments.core.utils.EndPointsUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacebookAPIServiceImpl implements FacebookAPIService{

    @Override
    public List<ComentarioTO> getCommentsLiveVideoFacebook(String liveVideoId, String accessToken) {

        String host_liveVideo = EndPointsUtils.getFacebookLiveVideoUrlByLiveVideoId(liveVideoId, accessToken);
        RestTemplate restTemplate = new RestTemplate();
        APIGraphLiveVideo apiGraphLiveVideo = restTemplate.getForObject(host_liveVideo, APIGraphLiveVideo.class);
        List<LiveVideosData> liveVideosData = apiGraphLiveVideo.getData();

        List<ComentarioTO> comentarioTOList = new ArrayList<>();
        for (LiveVideosData item : liveVideosData) {
            ComentarioTO comentarioTO = new ComentarioTO();
            comentarioTO.setDisplayMessage(item.getMessage());
            comentarioTO.setProfileImageUrl("");
            comentarioTO.setDisplayName(item.getFrom().getName());
            comentarioTOList.add(comentarioTO);
        }

        return comentarioTOList;
    }
}
