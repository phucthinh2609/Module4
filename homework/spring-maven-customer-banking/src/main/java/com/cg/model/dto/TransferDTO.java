package com.cg.model.dto;

public class TransferDTO {
    private String senderId;
    private String senderName;
    private String email;
    private String recipientId;
    private String balance;
    private String transferAmount;

    public TransferDTO() {
    }

    public TransferDTO(String senderId, String senderName, String email, String recipientId, String balance, String transferAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.email = email;
        this.recipientId = recipientId;
        this.balance = balance;
        this.transferAmount = transferAmount;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }
}
