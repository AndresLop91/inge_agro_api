package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.QuantityTypeData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA QuantityTypeData Abstraction
 */
public interface QuantityTypeRepositoryJPA extends JpaRepository<QuantityTypeData, Long> {
}
