package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.IdentificationTypeData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA IdentificationType Abstraction
 */
public interface IdentificationTypeRepositoryJPA extends JpaRepository<IdentificationTypeData, Long> {
}
