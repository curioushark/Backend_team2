package com.jdt8.bank.service;

import com.jdt8.bank.entity.Customer;
import com.jdt8.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Object saveCustomer(Customer cust){
        List<Customer> lstcst = customerRepository.findAll();
        for(Customer c : lstcst){
            if(c.getNik()== cust.getNik()||c.getEmail().equals(cust.getEmail())){
                return false;
            }
        }
        cust.setJoinDate(Date.valueOf(LocalDate.now()));
        customerRepository.save(cust);
        return true;
    }


}
