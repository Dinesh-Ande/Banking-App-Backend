package com.java.Banking.Constants;

public class AccountUrlConstants {
    public static final String APIS_BASE_URL = "/apis/accounts";
    public static final String CREATE = "/createAccount";
    public static final String GET = "/getAccount/{accountNumber}";
    public static final String DEPOSIT = "/depositAmount/{accountNumber}";
    public static final String WITHDRAW = "/withdrawAmount/{accountNumber}";
    public static final String GET_ALL = "/getAllAccounts";
    public static final String DELETE = "/deleteAccounts/{accountNumber}";
}
