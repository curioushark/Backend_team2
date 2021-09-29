package com.ghina.Bank_Team2.service;

import com.ghina.Bank_Team2.entity.Account;
import com.ghina.Bank_Team2.entity.Balance;
import com.ghina.Bank_Team2.entity.Customer;
import com.ghina.Bank_Team2.entity.temp.AccCust;
import com.ghina.Bank_Team2.entity.temp.TransInfo;
import com.ghina.Bank_Team2.repository.AccountRepo;
import com.ghina.Bank_Team2.repository.BalanceRepo;
import com.ghina.Bank_Team2.repository.CustomerRepo;
import com.ghina.Bank_Team2.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BalanceRepo balanceRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    public Object createAccount(AccCust data){
        List<Customer> lstCst = customerRepo.findAll();
        for (Customer cust : lstCst){
            if(data.getNik() == cust.getNik() && data.getEmail().equals(cust.getEmail())){
                Account acc = new Account();
                if (acc.getId()== null || acc.getId().equals("")){
                    acc.setId(UUID.randomUUID().toString());
                }
                acc.setCustomer(cust);
                acc.setDateOpened(Date.valueOf(LocalDate.now()));
                acc.setAccNumber(randomNumber());
                acc.setPin(data.getPin());
                accountRepo.save(acc);

                Balance newAccount = new Balance();
                newAccount.setBalance(0L);
                newAccount.setAccId(acc.getId());
                balanceRepo.save(newAccount);

                return acc.getAccNumber();

                }
            }
        return false;
    }

    private int randomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        int k = Integer.parseInt(String.format("%08d",number));
        return k;
    }
    public Object login(AccCust accCust){
        List<Account> lstacc = accountRepo.findAll();
        for (Account acc : lstacc){
            if (acc.getPin() == accCust.getPin() && acc.getAccNumber() == accCust.getAccNumber()){
                AccCust accs = new AccCust();
                accs.setId(acc.getId());
                accs.setAccNumber(acc.getAccNumber());
                return accs;
            }
        }
        return false;
    }
    public Object findAccountById(String id){
        Account acc = accountRepo.findById(id).orElse(null);
        Customer cust = customerRepo.findById(acc.getCustomer().getId()).orElse(null);
        if (cust != null){
            return cust;
        }
        return false;
    }
    public Object balanceInfo(String id) {
        Account acc = accountRepo.findById(id).orElse(null);
        Customer cust = customerRepo.findById(acc.getCustomer().getId()).orElse(null);
        Balance accBalance = balanceRepo.findByAccId(id);
        if (cust != null){
            AccCust accs= new AccCust();
            accs.setAccNumber(acc.getAccNumber());
            accs.setFullName(cust.getFullName());
            accs.setBalance(accBalance.getBalance());
            accs.setAccId(acc.getId());
            return accs;
        }
        return false;
    }
    public List<TransInfo>findTransaction(String id){
        return transactionRepo.transaction(id);
    }

}

