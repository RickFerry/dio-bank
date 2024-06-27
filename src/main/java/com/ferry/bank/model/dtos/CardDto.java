package com.ferry.bank.model.dtos;

import java.math.BigDecimal;

public record CardDto(Long id, String number, BigDecimal limit) {
}
