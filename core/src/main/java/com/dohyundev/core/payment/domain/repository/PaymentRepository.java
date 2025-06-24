package com.dohyundev.core.payment.domain.repository;

import com.dohyundev.core.payment.domain.model.Payment;
import com.dohyundev.core.payment.domain.model.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}