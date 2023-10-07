package com.project.urlshortener.service;

import com.project.urlshortener.entity.UrlMapping;
import com.project.urlshortener.exceptions.UrlNotFoundException;
import com.project.urlshortener.repository.UrlMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class UrlMappingService {

    @Autowired
    private UrlMappingRepo urlMappingrepo;



    public String generateShortCode(){
       return UUID.randomUUID().toString().substring(0, 8);
    }

    public UrlMapping shortenUrl(String originalUrl){
        String shortCode = generateShortCode();
        UrlMapping urlMapping = new UrlMapping();

        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortCode);

        return urlMappingrepo.save(urlMapping);
    }

    public String redirectToOriginalUrl(String shortCode){
        UrlMapping urlMapping = urlMappingrepo.findByshortUrl(shortCode);

        if(urlMapping != null){
            return urlMapping.getOriginalUrl();
        }else{
            throw new UrlNotFoundException("URL with short code " + shortCode + " not found.");
        }
    }

    public List<UrlMapping> getAllUrlMappings() {
        return urlMappingrepo.findAll();
    }
}
