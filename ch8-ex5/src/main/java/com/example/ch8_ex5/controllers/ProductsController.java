package com.example.ch8_ex5.controllers;

import com.example.ch8_ex5.model.Product;
import com.example.ch8_ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // Controller Action을 /products 경로에 매핑
    // @RequestMapping Annotation은 기본적으로 HTTP GET Method를 사용함
    // @GetMapping("/products")
    @RequestMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll(); // Service 객체를 통해 모든 상품 가져옴
        model.addAttribute("products", products); // 제품 목록을 뷰로 전송

        return "products.html";
        // 뷰 이름 반환되며, Dispatcher Servlet이 이를 받아
        // View를 렌더링
    }

    // @RequestMapping(path="/products", method=RequestMethod.POST)
    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name, @RequestParam double price, // 요청 매개변수 사용
            Model model) {
        // Product 객체 생성 및 초기화 후
        // ProductService에서 관리하는 products List에 저장
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);
        // 새로운 Product 인스턴스를 Service의 메서드 호출하여 제품 목록에 추가

        // 새 상품 추가했으니, 추가된 제품 목록으로 리렌더링 해야 함
        var products = productService.findAll(); // 상품 추가 후, 제품 목록 가져와 뷰에 전송
        model.addAttribute("products", products); // 제품 목록 가져와 뷰에 전송
        return "products.html"; // 렌더링할 뷰 이름 반환
    }
}