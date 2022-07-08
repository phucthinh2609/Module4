package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Query("UPDATE Customer AS c SET c.balance = c.balance + :transactionAmount WHERE c.id = :id")
    void incrementBalance(@Param("id") Long id, @Param("transactionAmount") BigDecimal transactionAmount);

    @Modifying
    @Query("UPDATE Customer AS c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id")
    void decrementBalance(@Param("id") Long id, @Param("transactionAmount")BigDecimal transactionAmount);
}
