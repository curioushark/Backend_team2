package com.jdt8.bank.service;

import com.jdt8.bank.entity.Accounts;
import com.jdt8.bank.entity.Customer;
import com.jdt8.bank.entity.temp.AccCust;
import com.jdt8.bank.repository.AccountRepository;
import com.jdt8.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Object createAccount(AccCust data) {
        List<Customer> lstCst = customerRepository.findAll();
        for (Customer c : lstCst) {
            if (data.getNik() == c.getNik() && data.getEmail().equals(c.getEmail())) {
                Accounts acc = new Accounts();
                acc.setCustomer(c);
                acc.setDateOpened(Date.valueOf(LocalDate.now()));
                acc.setAccNumber(randomNumber());
                acc.setPin(data.getPin());
                accountRepository.save(acc);
                return acc.getAccNumber();
            }
        }
        return false;
    }

    public int randomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        int k = Integer.parseInt(String.format("%08d", number));
        return k;
    }

    public Object login(AccCust accCust) {
        List<Accounts> lstacc = accountRepository.findAll();
        for (Accounts acc : lstacc) {
            if(acc.getPin()==accCust.getPin()&&acc.getAccNumber()==accCust.getAccNumber()){
                AccCust accs= new AccCust();
                accs.setId(acc.getId());
                return accs;
            }
        }
        return false;
    }

    public Object findByAccountId(String id){
        Accounts acc = accountRepository.findById(id).orElse(null);
        Customer cust = customerRepository.findById(acc.getCustomer().getId()).orElse(null);
        if(cust!=null){
            return cust;
        }
        return false;
    }


}
