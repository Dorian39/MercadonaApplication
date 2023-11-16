package com.mercadona.mercadona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercadonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadonaApplication.class, args);
	}
}

/*@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    // Contrôleur pour les opérations CRUD sur les produits
}

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    // Contrôleur pour les opérations CRUD sur les promotions
}
*/