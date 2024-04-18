package com.java.Banking.Service;

import com.java.Banking.RequestAndResponse.AccountRequestAndResponse;

import java.util.List;

public interface AccountService {

    AccountRequestAndResponse createAccount(AccountRequestAndResponse accountRequestAndResponse);

    AccountRequestAndResponse getAccount(Long accountNumber);

    AccountRequestAndResponse depositAmount(Long accountNumber, Double amount);

    AccountRequestAndResponse withdrawAmount(Long accountNumber, Double amount);

    List<AccountRequestAndResponse> getAllAccounts();

    void deleteAccount(Long accountNumber);

}
