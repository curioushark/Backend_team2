package com.jdt8.bank.repository;

import com.jdt8.bank.entity.Accounts;
import com.jdt8.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts,String> {

    List<Accounts> findByCustomer(Customer customer);
}
