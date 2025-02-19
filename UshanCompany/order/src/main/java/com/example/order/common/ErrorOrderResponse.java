package com.example.order.common;

public class ErrorOrderResponse implements orderResponse {
    private final String errorMessage;

    public ErrorOrderResponse(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
