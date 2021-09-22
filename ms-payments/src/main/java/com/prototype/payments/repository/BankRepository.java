package com.prototype.payments.repository;

import com.prototype.payments.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface BankRepository extends JpaRepository<BankModel, UUID> {
    Optional<BankModel> findByNameBankContaining(String nameBank);

}
