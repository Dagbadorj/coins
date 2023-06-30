package com.ds.coin.dto.response;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class RewardResponse implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}