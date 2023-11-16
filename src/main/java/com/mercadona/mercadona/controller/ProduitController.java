package com.mercadona.mercadona.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mercadona.mercadona.entity.Produit;
import com.mercadona.mercadona.entity.Categorie;
import com.mercadona.mercadona.repository.CategorieRepository;
import com.mercadona.mercadona.repository.ProduitRepository;
import com.mercadona.mercadona.service.ProduitService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/produit")

public class ProduitController {
    
    private final ProduitService produitService;

    @GetMapping("/create")
    public String afficherFormulaireCreationProduit(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categorieRepository.findAll()); // Récupère toutes les catégories existente
        return "creerProduit"; // le nom du fichier HTML pour le formulaire
    }

    @PostMapping("/create")
    public String creerProduit(@ModelAttribute Produit produit, Model model) {

        produitService.saveProduit(produit);
        model.addAttribute("produit", produit);
        model.addAttribute("categories", categorieRepository.findAll()); // Affecte la catégorie choisi à la création du produit
        return "confirmation"; // le nom du fichier HTML pour la confirmation
    }

    @GetMapping("/all")
    public String afficherTousLesProduits(Model model) {
        List<Produit> produits = produitService.lire();
        model.addAttribute("produits", produits);
        return "allproduit";
    }


    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    CategorieRepository categorieRepository;
    
    /*@PostMapping("/create")
    public Produit creer(@ModelAttribute Produit produit) {
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read() {
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.modifier(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return produitService.supprimer(id);
    }*/

    @PutMapping("/{produitId}/categorie/{categorieId}")
    Produit assignCategorieToProduit(
        @PathVariable Long produitId,
        @PathVariable Long categorieId
    ) {
        Produit produit = produitRepository.findById(produitId).get();
        Categorie categorie = categorieRepository.findById(categorieId).get();
        produit.setCategorie(categorie);
        return produitRepository.save(produit);
    }
}
