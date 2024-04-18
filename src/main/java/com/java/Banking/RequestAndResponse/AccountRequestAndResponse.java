package com.java.Banking.RequestAndResponse;

import lombok.Data;

@Data
public class AccountRequestAndResponse {
    private Long accountNumber;
    private String accountHolderName;
    private Double accountBalance;
}
