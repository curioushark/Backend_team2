package com.ghina.Bank_Team2.service;

import com.ghina.Bank_Team2.entity.Account;
import com.ghina.Bank_Team2.entity.Balance;
import com.ghina.Bank_Team2.entity.Transaction;
import com.ghina.Bank_Team2.entity.temp.AccCust;
import com.ghina.Bank_Team2.repository.AccountRepo;
import com.ghina.Bank_Team2.repository.BalanceRepo;
import com.ghina.Bank_Team2.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private BalanceRepo balanceRepo;

    @Autowired
    private AccountRepo accountRepo;

    public Object doWithdraw(AccCust data){
        Balance accBalance = balanceRepo.findByAccId(data.getAccId());
        if (accBalance.getBalance() !=0 || !(accBalance.getBalance() - data.getAmount() < 0 )){
            Long total = accBalance.getBalance() - data.getAmount();
            accBalance.setBalance(total);
            balanceRepo.save(accBalance);

            Transaction trans = new Transaction();
            trans.setToFrom(data.getToFrom());
            trans.setAmount(data.getAmount());
            trans.setAccId(data.getAccId());
            trans.setTransDate(new java.util.Date());
            trans.setBalance(accBalance.getBalance());
            trans.setType("Withdraw");
            transactionRepo.save(trans);

            AccCust accs = new AccCust();
            accs.setAccId(data.getAccId());
            return accs;
        }
        return false;
    }
    public Object doDeposit(Transaction data){
        Balance accBalance = balanceRepo.findByAccId(data.getAccId());
        Long total = accBalance.getBalance() + data.getAmount();
        accBalance.setBalance(total);
        balanceRepo.save(accBalance);
        data.setTransDate(new java.util.Date());
        data.setBalance(total);
        data.setType("Deposit");
        transactionRepo.save(data);

        AccCust accs = new AccCust();
        accs.setAccId(data.getAccId());
        return accs;
    }
    public Object withdrawPinValidation(AccCust data){
        Account acc = accountRepo.findById(data.getId()).orElse(null);
        if (acc != null){
            if (data.getAccId().equals(acc.getId()) && data.getPin() == acc.getPin()){
                return doWithdraw(data);
            }
        }
        return false;
    }
    public Object pinTransferValidation (AccCust data){
        Account acc = accountRepo.findById(data.getId()).orElse(null);
        Account acc2= accountRepo.findByAccNumber(data.getAccNumber()).orElse(null);
        if ((acc != null && acc2 != null)&&!(acc.getId().equals(acc2.getId()))) {
            data.setToFrom(acc2.getId());
            if (data.getAccId().equals(acc.getId()) && data.getPin() == acc.getPin()) {
                return doTransfer(data);
            }
        }
        return false;
    }
    public Object doTransfer(AccCust data){
        Balance acc = balanceRepo.findByAccId(data.getAccId());
        Balance acc2 = balanceRepo.findByAccId(data.getAccId());
        if (acc.getBalance() !=0 || !(acc.getBalance() - data.getAmount() < 0)){
            Long total = acc.getBalance() - data.getAmount();
            acc.setBalance(total);
            balanceRepo.save(acc);

            Transaction trans = new Transaction();
            trans.setToFrom(data.getToFrom());
            trans.setAmount(data.getAmount());
            trans.setTransDate(new java.util.Date());
            trans.setAccId(data.getAccId());
            trans.setBalance(data.getBalance());
            trans.setType("Transfer Out");
            transactionRepo.save(trans);

            Long total2 = acc2.getBalance() + data.getAmount();
            acc2.setBalance(total2);
            balanceRepo.save(acc2);
            Transaction trans2 = new Transaction();
            trans2.setTransDate(new java.util.Date());
            trans2.setToFrom(data.getToFrom());
            trans2.setAmount(data.getAmount());
            trans2.setAccId(data.getAccId());
            trans2.setBalance(trans2.getBalance());
            trans2.setType("Transfer In");
            transactionRepo.save(trans2);

            AccCust accs = new AccCust();
            accs.setId(acc.getId());
            return accs;
        }
        return false;
    }

}
