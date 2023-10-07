package com.project.urlshortener.repository;

import com.project.urlshortener.entity.UrlMapping;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMappingRepo extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByshortUrl(String shortUrl);
}
