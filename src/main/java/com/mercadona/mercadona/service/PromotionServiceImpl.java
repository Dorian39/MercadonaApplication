package com.mercadona.mercadona.service;

import com.mercadona.mercadona.entity.Promotion;
import com.mercadona.mercadona.repository.PromotionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion creer(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> lire() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion modifier(Long id, Promotion promotion) {
        return promotionRepository.findById(id)
            .map(p-> {
                p.setDebut(promotion.getDebut());
                p.setFin(promotion.getFin());
                p.setPourcentageRemise(promotion.getPourcentageRemise());
                /*p.setProduit(promotion.getProduit());*/
                return promotionRepository.save(p);
            }).orElseThrow(() -> new RuntimeException("Promotion non trouvée"));
    }

    @Override
    public String supprimer(Long id) {
        promotionRepository.deleteById(id);
        return "Promotion supprimée";
    }
    
}
