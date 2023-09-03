package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.ProductTypeData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA ProductType Abstraction
 */
public interface ProductTypeRepositoryJPA extends JpaRepository<ProductTypeData, Long> {
}
