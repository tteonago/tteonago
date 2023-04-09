package com.tteonago.terms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tteonago.terms.entity.Terms;

@Repository
public interface Termsrepository extends  JpaRepository<Terms, Long> {
}
