package com.urlshorter.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("shortUrlRepository")
public interface ShortUrlRepository extends JpaRepository<com.urlshorter.login.model.ShortUrl, Long> {

}
