package com.java.Banking.Service.Impl;

import com.java.Banking.Entity.Account;
import com.java.Banking.Exception.InsufficientBalanceException;
import com.java.Banking.Exception.NoAccountFoundException;
import com.java.Banking.Mapper.AccountMapper;
import com.java.Banking.Repository.AccountRepository;
import com.java.Banking.RequestAndResponse.AccountRequestAndResponse;
import com.java.Banking.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountRequestAndResponse createAccount(AccountRequestAndResponse accountRequestAndResponse) {
        Account account = AccountMapper.mapToAccount(accountRequestAndResponse);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountRequestAndResponse(savedAccount);
    }

    @Override
    public AccountRequestAndResponse getAccount(Long accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElseThrow(
                ()-> new NoAccountFoundException("no account exits with : "+accountNumber)
                );
        return AccountMapper.mapToAccountRequestAndResponse(account);
    }

    @Override
    public AccountRequestAndResponse depositAmount(Long accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber).orElseThrow(
                ()-> new NoAccountFoundException("no account exits with : "+accountNumber)
        );
        Double total = account.getAccountBalance() + amount;
        account.setAccountBalance(total);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountRequestAndResponse(updatedAccount);
    }

    @Override
    public AccountRequestAndResponse withdrawAmount(Long accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber).orElseThrow(
                ()-> new NoAccountFoundException("no account exits with : "+accountNumber)
        );
        if(account.getAccountBalance() < amount){
            throw new InsufficientBalanceException("Low Balance");
        }
        Double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountRequestAndResponse(updatedAccount);
    }

    @Override
    public List<AccountRequestAndResponse> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(AccountMapper::mapToAccountRequestAndResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElseThrow(
                ()-> new NoAccountFoundException("no account exits with : "+accountNumber)
        );
        accountRepository.deleteById(accountNumber);
    }
}
