package com.ds.coin.dto.request;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinRequest implements Serializable {

    private String name;
    private String origin;

}