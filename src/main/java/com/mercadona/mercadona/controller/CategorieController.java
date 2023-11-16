package com.mercadona.mercadona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.mercadona.mercadona.entity.Categorie;
import com.mercadona.mercadona.repository.CategorieRepository;
import com.mercadona.mercadona.service.CategorieService;

import lombok.*;

@RestController
@AllArgsConstructor
@RequestMapping("/categorie")

public class CategorieController {
    
    private final CategorieService categorieService;

    @Autowired
    CategorieRepository categorieRepository;

    @PostMapping("/create")
    public Categorie create(@RequestBody Categorie categorie) {
        return categorieService.creer(categorie);
    }

    @GetMapping("/read")
    public List<Categorie> read() {
        return categorieService.lire();
    }

    @PutMapping("/update/{id}")
    public Categorie update(@PathVariable Long id, @RequestBody Categorie categorie) {
        return categorieService.modifier(id, categorie);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return categorieService.supprimer(id);
    }
}
