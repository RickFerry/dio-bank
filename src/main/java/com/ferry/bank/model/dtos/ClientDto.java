package com.ferry.bank.model.dtos;

import java.util.Set;

public record ClientDto(Long id, String name, AccountDto account, CardDto card, Set<FeatureDto> features, Set<NewsDto> news) {
}
