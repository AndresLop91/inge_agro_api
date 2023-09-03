package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.GenderData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Gender Abstraction
 */
public interface GenderRepositoryJPA extends JpaRepository<GenderData, Long> {
}
