package com.ferry.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
}
