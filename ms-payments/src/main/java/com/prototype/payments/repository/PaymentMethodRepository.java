package com.prototype.payments.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.payments.model.PaymentMethodModel;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethodModel, UUID> {

   Optional<PaymentMethodModel> findByNameContaining(String name);
}
