package com.mercadona.mercadona.repository;

import com.mercadona.mercadona.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
}
