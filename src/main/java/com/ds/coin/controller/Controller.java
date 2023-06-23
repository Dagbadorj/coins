package com.ds.coin.controller;

import com.ds.coin.model.Coin;
import com.ds.coin.service.implementation.ServiceCoinImp;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("coin")
public class Controller {

    @Autowired
    private ServiceCoinImp service;

    @GetMapping
    public List<Coin> listCoin(){
        return service.listAll();
    }
    @PostMapping
    public String addCoin(@RequestBody Coin coin) {
        return service.saveCoin(coin);
    }
    @GetMapping("/{id}")
    public Coin getCoin(@PathVariable Integer id){
        return service.getCoin(id);

    }
    @PutMapping("/{id}")
    public String updateCoin(@RequestBody Coin updatedCoin, @PathVariable Integer id) {
        return service.modifyCoin(updatedCoin, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCoin(@PathVariable Integer id){
        service.removeCoin(id);
    }
}