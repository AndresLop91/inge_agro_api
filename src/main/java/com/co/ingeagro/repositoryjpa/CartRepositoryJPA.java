package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.CartData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Cart Abstraction
 */
public interface CartRepositoryJPA extends JpaRepository<CartData, Long> {
}
