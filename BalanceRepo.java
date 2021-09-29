package com.ghina.Bank_Team2.repository;

import com.ghina.Bank_Team2.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, String> {
    Balance findByAccId(String accId);
}
