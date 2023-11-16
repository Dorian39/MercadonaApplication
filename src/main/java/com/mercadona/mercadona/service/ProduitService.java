package com.mercadona.mercadona.service;

import com.mercadona.mercadona.entity.Produit;
import java.util.List;

public interface ProduitService {

    Produit creer(Produit produit);

    List<Produit> lire();

    Produit modifier(Long id, Produit produit);

    String supprimer(Long id);

    void saveProduit(Produit produit);
}
