package com.ds.coin.service;


import com.ds.coin.dto.request.CoinRequest;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.exception.NoSuchElementFoundException;

public interface CoinService {
    DataResponse listAll();
    StatusResponse addCoin(CoinRequest coin);
    DataResponse getCoin(Long id);
    StatusResponse updateCoin(CoinRequest coinRequest, Long coinId);
    StatusResponse deleteCoin(Long id);

}

