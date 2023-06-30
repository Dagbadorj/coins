package com.ds.coin.service.impl;

import com.ds.coin.constant.Action;
import com.ds.coin.constant.Common;
import com.ds.coin.dto.request.CoinRequest;
import com.ds.coin.dto.response.CoinResponse;
import com.ds.coin.dto.response.DataResponse;
import com.ds.coin.dto.response.StatusResponse;
import com.ds.coin.exception.NoSuchElementFoundException;
import com.ds.coin.exception.NotNullException;
import com.ds.coin.repository.CoinRepository;
import com.ds.coin.service.CoinService;
import com.ds.coin.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;
    @Override
    public DataResponse listAll(){
        List<Coin> coins = coinRepository.findAllByDeleted(Common.Flag.No);
        List<CoinResponse> coinResponses = new ArrayList<>();
        coins.forEach(coin -> {
            coinResponses.add(getCoinResponse(coin));
        });

        return new DataResponse(Common.isSuccess.success, coins);
    }

    @Override
    public StatusResponse addCoin(CoinRequest coinRequest)throws NotNullException{
        if(coinRequest.getName()!=null && coinRequest.getOrigin()!=null){
            Coin coin = new Coin();
            coinRepository.save(Mapping(Action.CREATE,coin, coinRequest));

            return new StatusResponse(Common.isSuccess.success, "Successfully created coin!");
        } else{
            throw new NotNullException("There is null value in properties");
        }
    }

    @Override
    public DataResponse getCoin(Long id) throws NoSuchElementFoundException{

        try {
            Coin coin = coinRepository.findByIdAndDeleted(id, Common.Flag.No)
                    .orElseThrow(() -> new NoSuchElementFoundException("Coin not found"));

            return new DataResponse(Common.isSuccess.success, getCoinResponse(coin));
        }catch (NoSuchElementFoundException e){

            return new DataResponse(Common.isSuccess.failed, e.getMessage());
        }
    }

    @Override
    public StatusResponse updateCoin(CoinRequest coinRequest, Long id) throws NoSuchElementFoundException{
        try{
            Coin coin = coinRepository.findByIdAndDeleted(id, Common.Flag.No)
                    .orElseThrow(() -> new NoSuchElementFoundException("Coin not found"));
            coinRepository.save(Mapping(Action.UPDATE, coin, coinRequest));

            return new StatusResponse(Common.isSuccess.success, "Updated successfully!");
        }catch (NoSuchElementFoundException e){

            return new StatusResponse(Common.isSuccess.failed, e.getMessage());
        }

    }

    @Override
    public StatusResponse deleteCoin(Long id) throws NoSuchElementFoundException{
        try {
            Coin coin = coinRepository.findByIdAndDeleted(id, Common.Flag.No)
                    .orElseThrow(() -> new NoSuchElementFoundException("Coin not found"));
            coinRepository.save(Mapping(Action.DELETE, coin, null));

            return new StatusResponse(Common.isSuccess.success, coin.getName() + " Deleted successfully!");
        }catch (NoSuchElementFoundException e){

            return new StatusResponse(Common.isSuccess.failed, e.getMessage());
        }
    }

    public CoinResponse getCoinResponse(Coin coin) {
        CoinResponse coinResponse = new CoinResponse();
        coinResponse.setId(coin.getId());
        coinResponse.setName(coin.getName());
        coinResponse.setOrigin(coin.getOrigin());
        coinResponse.setCreatedAt(coin.getCreatedAt().withNano(0));
        coinResponse.setModifiedAt(coin.getModifiedAt().withNano(   0));

        return coinResponse;
    }

    public Coin Mapping(Action action,
                        Coin coin,
                        CoinRequest coinRequest){
        if(action.equals(Action.UPDATE) || action.equals(Action.CREATE)){
            if(coinRequest.getName()!=null){
                coin.setName(coinRequest.getName());
            }
            if(coinRequest.getOrigin()!=null){
                coin.setOrigin(coinRequest.getOrigin());
            }
        }
        if(action.equals(Action.DELETE)){
            coin.setDeleted(Common.Flag.Yes);
        }

        return coin;
    }

}