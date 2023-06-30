package com.ds.coin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinResponse implements Serializable {

    private Long id;
    private String name;
    private String origin;
    private LocalDateTime createdAt;
    private LocalDateTime ModifiedAt;

}
