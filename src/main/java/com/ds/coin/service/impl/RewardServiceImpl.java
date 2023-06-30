package com.ds.coin.service.impl;

import com.ds.coin.constant.Common;
import com.ds.coin.dto.request.RewardRequest;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.service.RewardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import javax.xml.crypto.Data;
import java.util.Collections;

@Service
public class RewardServiceImpl implements RewardService {

    @Value("${reward.url}")
    private String url;

    @Value("${reward.id.url}")
    private String urlId;
    private final RestTemplate restTemplate;
    public RewardServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public StatusResponse addReward(RewardRequest rewardRequest)throws HttpClientErrorException {
        return restTemplate.postForObject(url, rewardRequest, StatusResponse.class);

    }

    public DataResponse listAllReward() {

        return this.restTemplate.getForObject(url, DataResponse.class);
    }

    public DataResponse getRewardById(Long id)throws HttpClientErrorException{
        return this.restTemplate.getForObject(urlId+id, DataResponse.class, id);
    }

    public StatusResponse deleteRewardById(Long id){

        return this.restTemplate.exchange(urlId+id, HttpMethod.DELETE, null, StatusResponse.class).getBody();
    }

    public StatusResponse updateRewardById(Long id, RewardRequest rewardRequest) throws HttpClientErrorException{

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        try{
            HttpEntity<RewardRequest> entity = new HttpEntity<>(rewardRequest, headers);

            return this.restTemplate.exchange(urlId+id, HttpMethod.PUT, entity, StatusResponse.class).getBody();

        }catch (HttpClientErrorException e){

            return new StatusResponse(Common.isSuccess.failed, e.getResponseBodyAsString());

        }

    }

}
