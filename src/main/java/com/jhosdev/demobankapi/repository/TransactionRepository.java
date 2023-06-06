package com.jhosdev.demobankapi.repository;

import com.jhosdev.demobankapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    boolean existsByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    boolean existsByAccount_NameCustomer(String nameCustomer);

    List<Transaction> findAllByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Transaction> findAllByAccount_NameCustomer(String nameCustomer);
}
