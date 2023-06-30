package com.ds.coin.dto.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class RewardRequest implements Serializable {

    private String name;
    private String description;
    private String imageUrl;

}