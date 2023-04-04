package com.tteonago.member.service;

import com.tteonago.member.entity.Freeboard;
import com.tteonago.member.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;


    public Page<Freeboard> getPageFreeBoard(int page, String keyword) {
        return freeBoardRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdDate")));
    }

}
