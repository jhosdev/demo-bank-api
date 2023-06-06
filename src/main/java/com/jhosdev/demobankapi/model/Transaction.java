package com.jhosdev.demobankapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "balance", nullable = false)
    private Double balance;


    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id", nullable = false) //, foreignKey = @ForeignKey(name = "fk_account_transaction")
    private Account account;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
    }
}
