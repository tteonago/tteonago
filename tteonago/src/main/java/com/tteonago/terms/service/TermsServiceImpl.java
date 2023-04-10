package com.tteonago.terms.service;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tteonago.terms.entity.Terms;
import com.tteonago.terms.repository.Termsrepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TermsServiceImpl {
    private final Termsrepository termsrepository;

    public Optional<Terms> findTermsByLastDate(){
        return termsrepository.findAll(Sort.by("createDate").descending())
                              .stream()
                              .findFirst();

    }
}
