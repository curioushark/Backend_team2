package com.ghina.Bank_Team2.controller;

import com.ghina.Bank_Team2.entity.Transaction;
import com.ghina.Bank_Team2.entity.temp.AccCust;
import com.ghina.Bank_Team2.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Object>doDeposit(@RequestBody Transaction data){
        Object x = transactionService.doDeposit(data);
        if (x.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Object>doWithdraw(@RequestBody AccCust data){
        Object x = transactionService.withdrawPinValidation(data);
        if (x.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/transfer")
    public ResponseEntity<Object>doTransfer(@RequestBody AccCust data){
        Object x = transactionService.pinTransferValidation(data);
        if (x.equals(false)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
