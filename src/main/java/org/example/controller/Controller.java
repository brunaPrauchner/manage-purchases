package org.example.controller;

import org.example.entity.*;
import org.example.repository.ProductRepository;
import org.example.repository.PurchaseProductRepository;
import org.example.repository.PurchaseRepository;
import org.example.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"checkstyle:MissingJavadocType", "checkstyle:Indentation"})
@RestController
public class Controller {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

   @GetMapping("/")
    public @ResponseBody Iterable<Store> getAllStores() {
       return storeRepository.findAll();
   }

    @PostMapping("/addStore")
    public Store addStore(@RequestBody Store store) {
        return storeRepository.save(store);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/addPurchase")
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @PostMapping("/addPurchaseProduct")
    public PurchaseProduct addPurchaseProduct(@RequestBody PurchaseProduct purchaseProduct) {
        PurchaseProductPk ppId = purchaseProduct.getPpId();
        purchaseProduct.setPpId(ppId);
        return purchaseProductRepository.save(purchaseProduct);
    }

    @GetMapping("/getAllPurchases")
    public @ResponseBody Iterable<Purchase> getAllPurchases() {
        // This returns a JSON or XML with the users
        return purchaseRepository.findAll();
    }
}