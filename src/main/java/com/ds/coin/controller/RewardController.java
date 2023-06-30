package com.ds.coin.controller;

import com.ds.coin.dto.request.RewardRequest;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.service.impl.RewardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardServiceImpl rewardServiceImpl;
    @PostMapping()
    public StatusResponse addReward(@RequestBody RewardRequest rewardRequest){
        return rewardServiceImpl.addReward(rewardRequest);
    }
    @GetMapping()
    public DataResponse listAllReward(){
        return rewardServiceImpl.listAllReward();
    }
    @GetMapping("/{id}")
    public DataResponse getReward(@PathVariable Long id){
        return rewardServiceImpl.getRewardById(id);
    }
    @DeleteMapping("/{id}")
    public StatusResponse deleteRewardById(@PathVariable Long id){
        return rewardServiceImpl.deleteRewardById(id);
    }
    @PutMapping("/{id}")
    public StatusResponse updateRewardById(@PathVariable Long id, @RequestBody RewardRequest rewardRequest){
        return rewardServiceImpl.updateRewardById(id,rewardRequest);
    }

}
