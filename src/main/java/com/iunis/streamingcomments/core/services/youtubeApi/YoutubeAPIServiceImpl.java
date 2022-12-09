package com.iunis.streamingcomments.core.services.youtubeApi;

import com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveChatData.ItemLiveChat;
import com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveChatData.LiveChatData;
import com.iunis.streamingcomments.core.domain.JsonStructure.YouTubeAPI.LiveVideoInfo.LiveVideoInfo;
import com.iunis.streamingcomments.core.keys.DefaultParamsKey;
import com.iunis.streamingcomments.core.keys.PartApiYouTubeEnum;
import com.iunis.streamingcomments.core.dto.ComentarioTO;
import com.iunis.streamingcomments.core.utils.EndPointsUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeAPIServiceImpl implements YoutubeAPIService{
    @Override
    public String getActiveLiveChatId(String videoId, String apiKey) {
        String host_resource_video = EndPointsUtils.getYoutubeStreamingUrlByVideoId(videoId, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        LiveVideoInfo liveVideoInfo = restTemplate.getForObject(host_resource_video, LiveVideoInfo.class);

        return liveVideoInfo.getItems().get(0).getLiveStreamingDetails().getActiveLiveChatId();
    }

    @Override
    public List<ComentarioTO> getCommentsLiveChatYoutube(String videoId, String apiKey) {

        String host_activeLiveChatId = DefaultParamsKey.HOST_YOUTUBE_API_V3_MESSAGE + "?key=" + apiKey + "&liveChatId=" + getActiveLiveChatId(videoId, apiKey) +"&part="+ PartApiYouTubeEnum.id+","+PartApiYouTubeEnum.snippet+","+PartApiYouTubeEnum.authorDetails;
        RestTemplate restTemplate = new RestTemplate();
        LiveChatData liveChatData = restTemplate.getForObject(host_activeLiveChatId, LiveChatData.class);
        List<ItemLiveChat> itemsLiveChat = liveChatData.getItems();

        List<ComentarioTO> comentarioTOList = new ArrayList<>();
        for (ItemLiveChat itemLiveChat : itemsLiveChat) {
            ComentarioTO comentarioTO = new ComentarioTO();
            comentarioTO.setDisplayMessage(itemLiveChat.getSnippet().getDisplayMessage());
            comentarioTO.setProfileImageUrl(itemLiveChat.getAuthorDetails().getProfileImageUrl());
            comentarioTO.setDisplayName(itemLiveChat.getAuthorDetails().getDisplayName());
            comentarioTOList.add(comentarioTO);
        }

        return comentarioTOList;
    }
}
