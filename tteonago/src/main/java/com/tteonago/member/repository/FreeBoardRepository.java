package com.tteonago.member.repository;

import com.tteonago.member.entity.Freeboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FreeBoardRepository extends JpaRepository<Freeboard, Long> {
    Page<Freeboard> findAllByDeletedIsFalse(Pageable pageable);

    Page<Freeboard> findByTitleContaining(String title, Pageable pageable);

    Page<Freeboard> findByContentsContaining(String contents, Pageable pageable);

    Page<Freeboard> findByTitleContainingOrContentsContaining(String keyword, Pageable pageable);
}
