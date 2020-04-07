package com.farmer.css.redisConnection.controller;

import com.farmer.css.redisConnection.model.TransactionNotification;


public class ResponseHandler {
    public TransactionNotification constructSucessResponse(){
        TransactionNotification transactionNotification = new TransactionNotification();
        transactionNotification.setTransactionCode("200");
        transactionNotification.setTranscationMessage("Key Value Pair is sucessfully updated in Redis");
        transactionNotification.setTransactionStatus("Sucess");
        return transactionNotification;
    }
    public TransactionNotification constructURIExceptionResponse(String message){
        TransactionNotification transactionNotification = new TransactionNotification();
        transactionNotification.setTranscationMessage(message);
        transactionNotification.setTransactionStatus("Error");
        return transactionNotification;
    }
    public TransactionNotification constructGenericExceptionResponse(String message){
        TransactionNotification transactionNotification = new TransactionNotification();
        transactionNotification.setTranscationMessage(message);
        transactionNotification.setTransactionStatus("Error");
        return transactionNotification;
    }
}
