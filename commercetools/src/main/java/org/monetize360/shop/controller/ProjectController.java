package org.monetize360.shop.controller;

import lombok.RequiredArgsConstructor;
import org.monetize360.shop.service.CommercetoolsApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final CommercetoolsApiService apiService;

    @GetMapping
    public ResponseEntity<String> getProjectInfo() {
        return apiService.getProjectInfo();
    }
} 