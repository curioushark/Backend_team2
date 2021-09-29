package com.ghina.Bank_Team2.service;

import com.ghina.Bank_Team2.entity.Customer;
import com.ghina.Bank_Team2.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Object saveCustomer (Customer cust){
        List<Customer> lstcst = customerRepo.findAll();
        for (Customer c : lstcst){
            if (c.getNik()== cust.getNik() || c.getEmail().equals(cust.getEmail())){
                return false;
            }
        }
        cust.setJoinDate(Date.valueOf(LocalDate.now()));
        customerRepo.save(cust);
        return true;
    }
}
