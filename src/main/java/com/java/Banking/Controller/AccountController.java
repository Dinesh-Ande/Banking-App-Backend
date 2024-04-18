package com.java.Banking.Controller;

import com.java.Banking.Constants.AccountUrlConstants;
import com.java.Banking.RequestAndResponse.AccountRequestAndResponse;
import com.java.Banking.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(AccountUrlConstants.APIS_BASE_URL)
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Create Account API
    @PostMapping(AccountUrlConstants.CREATE)
    public ResponseEntity<AccountRequestAndResponse> createAccount(@RequestBody AccountRequestAndResponse accountRequestAndResponse){
        AccountRequestAndResponse createdAccount = accountService.createAccount(accountRequestAndResponse);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    //Get Account API
    @GetMapping(AccountUrlConstants.GET)
    public ResponseEntity<AccountRequestAndResponse> getAccount(@PathVariable("accountNumber") Long accountNumber){
        AccountRequestAndResponse gotAccount = accountService.getAccount(accountNumber);
        return ResponseEntity.ok(gotAccount);
    }

    //Deposit API
    @PutMapping(AccountUrlConstants.DEPOSIT)
    public ResponseEntity<AccountRequestAndResponse> depositAmount(@PathVariable("accountNumber") Long accountNumber, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountRequestAndResponse updatedBalance = accountService.depositAmount(accountNumber, amount);
        return ResponseEntity.ok(updatedBalance);
    }

    //Withdraw API
    @PutMapping(AccountUrlConstants.WITHDRAW)
    public ResponseEntity<AccountRequestAndResponse> withdrawAmount(@PathVariable("accountNumber") Long accountNumber, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountRequestAndResponse updatedBalance = accountService.withdrawAmount(accountNumber, amount);
        return ResponseEntity.ok(updatedBalance);
    }

    //Get_All API
    @GetMapping(AccountUrlConstants.GET_ALL)
    public ResponseEntity<List<AccountRequestAndResponse>> getAllAccounts(){
        List<AccountRequestAndResponse> getAllAccounts = accountService.getAllAccounts();
        return ResponseEntity.ok(getAllAccounts);
    }

    //Delete API
    @DeleteMapping(AccountUrlConstants.DELETE)
    public ResponseEntity<String> deleteAccount(@PathVariable("accountNumber") Long accountNumber){
        accountService.deleteAccount(accountNumber);
        return  ResponseEntity.ok("Account Deleted Successfully");
    }
}
