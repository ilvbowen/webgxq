package com.nyist.utility;

/**
 * Created by kingcos on 06/02/2017.
 */
public enum StatusCode {
    OK(0),
    ERR(1);

    private Integer statusCode;

    StatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
