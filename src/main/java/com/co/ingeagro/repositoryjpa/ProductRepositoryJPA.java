package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJPA extends JpaRepository<ProductData, Long> {

}
