package com.nyist.utility;

import java.util.List;

/**
 * Created by kingcos on 06/02/2017.
 */
public class ResultMessage<E> {

    private Integer statusCode;
    private List<E> data;

    public ResultMessage(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ResultMessage(Integer statusCode, List<E> data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
