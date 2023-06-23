package com.ds.coin.service.implementation;


import com.ds.coin.repository.CoinRepository;
import com.ds.coin.service.ServiceCoin;
import com.ds.coin.model.Coin;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ServiceCoinImp implements ServiceCoin{

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> listAll(){
        return coinRepository.findAll();
    }
    public String saveCoin(Coin coin){
        try {
            coinRepository.save(coin);
            return "Added successfully";
        }catch (NotReadablePropertyException e){
            return "Something went wrong!";
        }
    }
    public Coin getCoin(Integer id){
        try {
            Coin coin = (Coin) coinRepository.findAllById(Collections.singleton(id));
            return new ResponseEntity<Coin>(coin, HttpStatus.OK).getBody();
        }catch (NoSuchElementException e){
            return new ResponseEntity<Coin>(HttpStatus.NOT_FOUND).getBody();
        }

    }
    public String modifyCoin(Coin updatedCoin, Integer id){
        Coin existingCoin = getCoin(id);
        if (existingCoin != null) {
            existingCoin.setName(updatedCoin.getName());
            existingCoin.setOrigin(updatedCoin.getOrigin());
            coinRepository.save(existingCoin);
            return "Product updated successfully!";
        } else {
            return "Product not found!";
        }
    }
    public void removeCoin(Integer id){
        coinRepository.deleteById(id);
    }
}
