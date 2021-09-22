package com.prototype.payments.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototype.payments.model.CardModel;

public interface CardRepository extends JpaRepository<CardModel, UUID> {

}
