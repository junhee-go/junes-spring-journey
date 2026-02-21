package com.example.ch10_ex4.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Country;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // http 응답 상태를 202 Accepted로 설정!
                .header("continent", "Europe") // 사용자 정의 헤더 추가
                .header("capital", "Paris") // 사용자 정의 헤더 추가
                .header("favorite_food", "cheese and wine") // 사용자 정의 헤더 추가
                .body(c); // Response Body는 Country Object로!
    }
}