package com.ghina.Bank_Team2.repository;

import com.ghina.Bank_Team2.entity.Account;
import com.ghina.Bank_Team2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, String> {
    List<Account>findByCustomer(Customer customer);

    Optional<Account> findByAccNumber(int accNumber);
}
