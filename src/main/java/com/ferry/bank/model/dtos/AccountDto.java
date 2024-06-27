package com.ferry.bank.model.dtos;

import java.math.BigDecimal;

public record AccountDto(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {
}
