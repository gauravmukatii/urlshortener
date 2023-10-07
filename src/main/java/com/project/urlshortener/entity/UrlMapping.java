package com.project.urlshortener.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "url_shortener")
public class UrlMapping {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   private String originalUrl;
   private String shortUrl;
   private LocalDate creationDate;
   private LocalDate expirationDate;

    public UrlMapping() {
    }

    public UrlMapping(Long id, String originalUrl, String shortUrl, LocalDate creationDate, LocalDate expirationDate) {
        Id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
