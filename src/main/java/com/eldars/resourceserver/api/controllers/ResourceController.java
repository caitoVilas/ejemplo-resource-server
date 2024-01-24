package com.eldars.resourceserver.api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author claudio.vilas
 * date 01/2024
 * description
 */

@RestController
@RequestMapping("/resources")
@Slf4j
public class ResourceController {

    @GetMapping("/user")
    public ResponseEntity<String> user(Authentication authentication){
        return ResponseEntity.ok("bienvenido ".concat(authentication.getName()));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> admin(Authentication authentication){
        return ResponseEntity.ok("Bienvenido ".concat(authentication.getName()));
    }

    @GetMapping("/management")
    @PreAuthorize("hasRole('ROLE_MANAGEMENT')")
    public ResponseEntity<String> management(Authentication authentication){
        return ResponseEntity.ok("Bienvenido ".concat(authentication.getName()));
    }
}
