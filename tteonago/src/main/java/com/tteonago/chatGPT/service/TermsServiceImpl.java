package com.tteonago.chatGPT.service;

import com.tteonago.chatGPT.entity.Terms;
import com.tteonago.chatGPT.repository.Termsrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
