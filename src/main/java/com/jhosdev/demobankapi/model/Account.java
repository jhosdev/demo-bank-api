package com.jhosdev.demobankapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_customer", nullable = false, length = 50)
    private String nameCustomer;

    @Column(name = "number_account", nullable = false, length = 10)
    private String numberAccount;
}
