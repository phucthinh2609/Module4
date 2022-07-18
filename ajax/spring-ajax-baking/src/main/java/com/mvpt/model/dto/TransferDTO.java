package com.mvpt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferDTO {
    private String senderId;
    private String senderName;
    private String email;
    private String recipientId;
    private String balance;
    private String transferAmount;

}
