package com.mercadona.mercadona.entity;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorie")
@Getter
@Setter
@NoArgsConstructor
public class Categorie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private Set<Produit> produits;

    public Set<Produit> getProduits() {
        return this.produits;
    }

    public String getLibelle() {
        return libelle;
    }
}
