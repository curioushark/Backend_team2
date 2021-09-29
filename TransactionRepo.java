package com.ghina.Bank_Team2.repository;

import com.ghina.Bank_Team2.entity.Transaction;
import com.ghina.Bank_Team2.entity.temp.TransInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,String> {
    List<Transaction>findAllByAccId(String accId);

    @Query(
            value="select t.trans_date as transDate,t.type as type ," +
                    "t.amount as amount ,t.balance as balance ," +
                    "a.acc_number as accNumber,c.fullname as fullname"
                    +" from trx_transaction t "
                    +" full join mst_account a "
                    +" on a.id = t.to_from "
                    +" full join mst_customer c "
                    +" on c.id = a.customer_id where t.acc_id = :accId",
            nativeQuery = true)

    public List<TransInfo>transaction(@Param("accId")String id);
}
