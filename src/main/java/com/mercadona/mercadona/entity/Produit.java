package com.mercadona.mercadona.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produit")
@Getter
@Setter
@NoArgsConstructor
public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private Set<Promotion> promotions;

    public Set<Promotion> getPromotions() {
        return this.promotions;
    }
}
