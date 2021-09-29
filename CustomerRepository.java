package com.ghina.Bank_Team2.repository;

import com.ghina.Bank_Team2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    List<Customer> findByNik(int nik);
}
