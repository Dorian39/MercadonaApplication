package com.mercadona.mercadona.service;

import com.mercadona.mercadona.entity.Promotion;
import java.util.List;

public interface PromotionService {
    
    Promotion creer(Promotion promotion);

    List<Promotion> lire();

    Promotion modifier(Long id, Promotion promotion);

    String supprimer(Long id);
}
