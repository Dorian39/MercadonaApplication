package com.mercadona.mercadona.repository;

import com.mercadona.mercadona.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
}
