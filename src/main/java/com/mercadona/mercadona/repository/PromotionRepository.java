package com.mercadona.mercadona.repository;

import com.mercadona.mercadona.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long>{
    
}
