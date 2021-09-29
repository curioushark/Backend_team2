package com.ghina.Bank_Team2.controller;

import com.ghina.Bank_Team2.entity.Customer;
import com.ghina.Bank_Team2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public ResponseEntity<Object>saveCustomer(@RequestBody Customer cust){
        Object x = customerService.saveCustomer(cust);
        if (x.equals(false)){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
