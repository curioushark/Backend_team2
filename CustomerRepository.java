package com.jdt8.bank.repository;

import com.jdt8.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {

   List<Customer> findByNik(int nik);
}
