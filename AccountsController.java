package com.ghina.Bank_Team2.controller;

import com.ghina.Bank_Team2.entity.temp.AccCust;
import com.ghina.Bank_Team2.entity.temp.TransInfo;
import com.ghina.Bank_Team2.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    private AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<Object>createAccount(@RequestBody AccCust data){
        Object account = accountService.createAccount(data);
        if (account.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Object>login(@RequestBody AccCust data){
        Object send= accountService.createAccount(data);
        if (send.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/info/{id}")
    public ResponseEntity<Object>findCustomer(@PathVariable("id") String id){
        Object x = accountService.balanceInfo(id);
        if (x.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findtrans/{id}")
    public ResponseEntity<List<TransInfo>>findTrans(@PathVariable("id") String id){
        return new ResponseEntity<>(accountService.findTransaction(id),HttpStatus.OK);
    }
}
