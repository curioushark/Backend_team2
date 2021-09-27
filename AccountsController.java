package com.jdt8.bank.controller;


import com.jdt8.bank.entity.Accounts;
import com.jdt8.bank.entity.temp.AccCust;
import com.jdt8.bank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @PostMapping("/save")
    public ResponseEntity<Object> createAccount(@RequestBody AccCust data){
        Object accounts = accountsService.createAccount(data);
        if(accounts.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        }
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AccCust data){
        Object send = accountsService.login(data);
        if(send.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        }
        return new ResponseEntity<>(send,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findCustomer(@PathVariable("id")String id){
        Object x = accountsService.findByAccountId(id);
        if(x.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        }
        return new ResponseEntity<>(x,HttpStatus.OK);
    }


}
