package com.ds.coin.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class DataResponse implements Serializable {

    private String status;
    private Object data;

}
