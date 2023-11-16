package com.mercadona.mercadona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.mercadona.mercadona.entity.Produit;
import com.mercadona.mercadona.entity.Promotion;
import com.mercadona.mercadona.repository.ProduitRepository;
import com.mercadona.mercadona.repository.PromotionRepository;
import com.mercadona.mercadona.service.PromotionService;

import lombok.*;

@RestController
@AllArgsConstructor
@RequestMapping("/promotion")

public class PromotionController {
    
    private final PromotionService promotionService;

    @Autowired
    PromotionRepository promotionRepository;

    @Autowired
    ProduitRepository produitRepository;

    @PostMapping("/create")
    public Promotion create(@RequestBody Promotion promotion) {
        return promotionService.creer(promotion);
    }

    @GetMapping("/read")
    public List<Promotion> read() {
        return promotionService.lire();
    }

    @PutMapping("/update/{id}")
    public Promotion update(@PathVariable Long id, @RequestBody Promotion promotion) {
        return promotionService.modifier(id, promotion);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return promotionService.supprimer(id);
    }

    @PutMapping("/{promotionId}/produit/{produitId}")
    Promotion assignProduitToPromotion(
        @PathVariable Long promotionId,
        @PathVariable Long produitId
    ) {
        Promotion promotion = promotionRepository.findById(promotionId).get();
        Produit produit = produitRepository.findById(produitId).get();
        promotion.setProduit(produit);
        return promotionRepository.save(promotion);
    }
}
