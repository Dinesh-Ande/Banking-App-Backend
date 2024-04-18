package com.java.Banking.Mapper;

import com.java.Banking.Entity.Account;
import com.java.Banking.RequestAndResponse.AccountRequestAndResponse;

public class AccountMapper {

    public static Account mapToAccount(AccountRequestAndResponse accountRequestAndResponse){
        Account account = new Account();
        account.setAccountNumber(accountRequestAndResponse.getAccountNumber());
        account.setAccountHolderName(accountRequestAndResponse.getAccountHolderName());
        account.setAccountBalance(accountRequestAndResponse.getAccountBalance());
        return account;
    }

    public static AccountRequestAndResponse mapToAccountRequestAndResponse(Account account){
        AccountRequestAndResponse accountRequestAndResponse = new AccountRequestAndResponse();
        accountRequestAndResponse.setAccountNumber(account.getAccountNumber());
        accountRequestAndResponse.setAccountHolderName(account.getAccountHolderName());
        accountRequestAndResponse.setAccountBalance(account.getAccountBalance());
        return accountRequestAndResponse;
    }
}
