package com.mercadona.mercadona.service;

import com.mercadona.mercadona.entity.Categorie;
import com.mercadona.mercadona.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie creer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> lire() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie modifier(Long id, Categorie categorie) {
        return categorieRepository.findById(id)
            .map(p-> {
                p.setLibelle(categorie.getLibelle());
                return categorieRepository.save(p);
            }).orElseThrow(() -> new RuntimeException("Categorie trouvée !"));
    }

    @Override
    public String supprimer(Long id) {
        categorieRepository.deleteById(id);
        return "Catégorie supprimée !";
    }    
}
