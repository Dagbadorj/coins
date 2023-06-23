package com.ds.coin.service;


import com.ds.coin.dto.CoinDto;
import com.ds.coin.model.Coin;

import java.util.List;

public interface ServiceCoin{
    List<Coin> listAll();
    String saveCoin(Coin coin);
    Coin getCoin(Integer id);
    String modifyCoin(Coin coin, Integer id);
    void removeCoin(Integer id);

}

