package com.example.ch10_ex3.controllers;

import com.example.ch10_ex3.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        Country c = Country.of("France", 67); // Country 객체 생성
        return c; // Action은 Country Type의 객체를 반환함
        // 즉, Response Body에 객체가 반환된다!
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);

        return List.of(c1, c2);
        // List Class에도 Country.of와 같은 메서드가 있음
    }
}