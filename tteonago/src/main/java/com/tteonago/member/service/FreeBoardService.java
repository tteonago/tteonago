package com.tteonago.member.service;

import com.tteonago.member.entity.Freeboard;
import com.tteonago.member.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    public Optional<Freeboard> findFreeboardById(String fId) {
        return freeBoardRepository.findById(Long.parseLong(fId));
    }

    public Page<Freeboard> getPageFreeBoard(int page, String keyword) {
        return freeBoardRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdDate")));
    }

    public Freeboard saveFreeBoard(Freeboard freeboard) {
        return freeBoardRepository.save(freeboard);
    }

    public void deleteFreeBoard(Freeboard freeboard){
        freeBoardRepository.delete(freeboard);
    }

}
