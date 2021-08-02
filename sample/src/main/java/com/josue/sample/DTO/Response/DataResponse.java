package com.josue.sample.DTO.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class DataResponse<T> extends SimpleResponse{
    private T data;

    public DataResponse(T data,String error, boolean success){
        super(success, error);
        this.data =  data;
    }
}
