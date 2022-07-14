package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Customer AS c SET c.balance = c.balance + :transactionAmount WHERE c.id = :id")
    void incrementBalance(@Param("id") Long id, @Param("transactionAmount") BigDecimal transactionAmount);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Customer AS c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id")
    void decrementBalance(@Param("id") Long id, @Param("transactionAmount")BigDecimal transactionAmount);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Customer AS c SET c.deleted = 1 WHERE c.id = :id")
    void updateDeleted(@Param("id") Long id);

    List<Customer> findAllByIdNot(Long id);

    List<Customer> findAllByDeletedFalse();
}
