package com.iunis.streamingcomments.core.utils;

import com.iunis.streamingcomments.core.keys.DefaultParamsKey;
import com.iunis.streamingcomments.core.keys.PartApiYouTubeEnum;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;

import java.io.IOException;

public class EndPointsUtils {

    public static String getYoutubeStreamingUrlByVideoId(String videoId, String apiKey){
        HttpMethod method = new GetMethod(DefaultParamsKey.HOST_BASE_URL_YOUTUBE+"/videos");
        String urlResult = "";
        try {
            NameValuePair param1 = new NameValuePair("part", URIUtil.encodeQuery(String.valueOf(PartApiYouTubeEnum.liveStreamingDetails)));
            NameValuePair param2 = new NameValuePair("id", URIUtil.encodeQuery(String.valueOf(videoId)));
            NameValuePair param3 = new NameValuePair("key", URIUtil.encodeQuery(String.valueOf(apiKey)));
            NameValuePair[] params = new NameValuePair[]{param1,param2,param3};
            method.setQueryString(params);
            urlResult = String.valueOf(method.getURI());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            method.releaseConnection();
        }
        return urlResult;
    }

    public static String getFacebookLiveVideoUrlByLiveVideoId(String liveVideoId, String accessToken){
        HttpMethod method = new GetMethod(DefaultParamsKey.HOST_BASE_URL_FACEBOOK+"/v15.0/"+liveVideoId+"/comments");
        String urlResult = "";
        try {
            NameValuePair param = new NameValuePair("access_token", URIUtil.encodeQuery(String.valueOf(accessToken)));
            NameValuePair[] params = new NameValuePair[]{param};
            method.setQueryString(params);
            urlResult = String.valueOf(method.getURI());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            method.releaseConnection();
        }
        return urlResult;
    }
}
