package com.ds.coin.service;

import com.ds.coin.dto.request.RewardRequest;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;

public interface RewardService {
    StatusResponse addReward(RewardRequest rewardRequest);
    DataResponse listAllReward();
    DataResponse getRewardById(Long id);
    StatusResponse deleteRewardById(Long id);
    StatusResponse updateRewardById(Long id, RewardRequest rewardRequest);
}
