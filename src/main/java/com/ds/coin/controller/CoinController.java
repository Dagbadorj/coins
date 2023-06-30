package com.ds.coin.controller;

import com.ds.coin.dto.request.CoinRequest;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.service.impl.CoinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coin")
public class CoinController {

    @Autowired
    private CoinServiceImpl service;
    @GetMapping
    public DataResponse listCoin(){
        return service.listAll();
    }
    @PostMapping
    public StatusResponse addCoin(@RequestBody CoinRequest coin) {
        return service.addCoin(coin);
    }
    @GetMapping("/{id}")
    public DataResponse getCoin(@PathVariable("id") Long id){
        return service.getCoin(id);
    }
    @PutMapping("/{id}")
    public StatusResponse updateCoin(@RequestBody CoinRequest coinRequest, @PathVariable("id") Long coinId) {
        return service.updateCoin(coinRequest, coinId);
    }
    @DeleteMapping("/{id}")
    public StatusResponse deleteCoin(@PathVariable("id") Long id){
        return service.deleteCoin(id);
    }

}
