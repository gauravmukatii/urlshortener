package com.project.urlshortener.controller;

import com.project.urlshortener.entity.UrlMapping;
import com.project.urlshortener.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlMappingController {

    @Autowired
    private UrlMappingService urlMappingService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlMapping> shortenCode(@RequestBody String originalUrl){
        UrlMapping urlMapping = urlMappingService.shortenUrl(originalUrl);
        return ResponseEntity.status(HttpStatus.CREATED).body(urlMapping);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode){
        String originalUrl = urlMappingService.redirectToOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", originalUrl)
                .build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UrlMapping>> getAllMappings(){
        List<UrlMapping> getAll= urlMappingService.getAllUrlMappings();
        return ResponseEntity.status(HttpStatus.FOUND).body(getAll);
    }

}
