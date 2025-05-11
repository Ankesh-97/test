package org.monetize360.shop.controller;

import lombok.RequiredArgsConstructor;
import org.monetize360.shop.service.CommercetoolsAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CommercetoolsAuthService authService;

    @GetMapping("/token")
    public ResponseEntity<String> getAuthToken() {
        String token = authService.getAccessToken();
        return ResponseEntity.ok(token);
    }
} 