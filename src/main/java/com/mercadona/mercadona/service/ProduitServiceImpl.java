package com.mercadona.mercadona.service;

import com.mercadona.mercadona.entity.Produit;
import com.mercadona.mercadona.repository.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
            .map(p-> {
                p.setLibelle(produit.getLibelle());
                p.setDescription(produit.getDescription());
                p.setPrix(produit.getPrix());
                p.setImage(produit.getImage());
                return produitRepository.save(p);
            }).orElseThrow(() -> new RuntimeException("Produit non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé";
    }

    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }    
}
