package com.tteonago.chatGPT.repository;

import com.tteonago.chatGPT.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Termsrepository extends JpaRepository<Terms, Long> {
}
