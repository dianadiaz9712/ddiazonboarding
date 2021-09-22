package com.prototype.payments.repository;

import com.prototype.payments.model.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<CurrencyModel, UUID> {
 
	Optional<CurrencyModel> findByCodeCurrencyContaining(String codeCurrency);
 
}
