package com.farmer.css.redisConnection.model;


import java.io.Serializable;
import java.util.List;

public class TransactionNotification {
 private String transactionStatus;
 private String transactionCode;

 public String getTransactionStatus() {
  return transactionStatus;
 }

 public void setTransactionStatus(String transactionStatus) {
  this.transactionStatus = transactionStatus;
 }

 public String getTransactionCode() {
  return transactionCode;
 }

 public void setTransactionCode(String transactionCode) {
  this.transactionCode = transactionCode;
 }

 public String getTranscationMessage() {
  return transcationMessage;
 }

 public void setTranscationMessage(String transcationMessage) {
  this.transcationMessage = transcationMessage;
 }

 private String transcationMessage;

}