package com.example.ch12_ex1.controllers;

import com.example.ch12_ex1.model.Purchase;
import com.example.ch12_ex1.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase") // /purchase 경로로 들어오는 http request를 담당하는 class
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    // DI
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
        // Client가 구매 record를 DB에 저장하려고 호출할 Endpoint를 구현
        // Action이 HTTP Request Body에서 가져온 data를 유지하고자
        // repository의 storePurchase() 메서드를 호출함
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
        /*
        클라이언트가 구매 테이블에서 모든 레코드를 가져오려고 호출할 엔드포인트를 구현
        Action은 repository의 메서드를 사용하여 DB에서 데이터를 가져오고,
        HTTP Response Body로 Client에 데이터를 반환함
         */
    }
}