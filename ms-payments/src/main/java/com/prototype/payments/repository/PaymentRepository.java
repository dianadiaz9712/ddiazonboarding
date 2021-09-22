package com.prototype.payments.repository;

import com.prototype.payments.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface PaymentRepository extends JpaRepository<PaymentModel, UUID> {
}
